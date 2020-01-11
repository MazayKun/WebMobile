package ru.mikheev.kirill.servlets;

import ru.mikheev.kirill.dao.IUserDAO;
import ru.mikheev.kirill.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

@WebServlet("/Authorization")
public class AuthorizationServlet extends HttpServlet {

    private IUserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = (IUserDAO) getServletContext().getAttribute("userDao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/AuthPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = userDAO.getUserByName(name);
        if(password.equals(user.getPassword())) {
            getServletContext().setAttribute("isAuth", true);
            resp.sendRedirect(req.getContextPath() + "/Menu");
        }else{
            req.getRequestDispatcher("/PermissionDenied.jsp").forward(req, resp);
        }
    }
}
