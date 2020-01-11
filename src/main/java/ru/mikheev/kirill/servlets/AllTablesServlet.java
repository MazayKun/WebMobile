package ru.mikheev.kirill.servlets;

import ru.mikheev.kirill.dao.IMobileDAO;
import ru.mikheev.kirill.dao.IUserDAO;
import ru.mikheev.kirill.pojo.Mobile;
import ru.mikheev.kirill.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

@WebServlet("/AllTablesList")
public class AllTablesServlet extends HttpServlet {

    private IMobileDAO mobileDAO;
    private IUserDAO userDAO;

    @Override
    public void init() throws ServletException {
        mobileDAO = (IMobileDAO) getServletContext().getAttribute("dao");
        userDAO = (IUserDAO) getServletContext().getAttribute("userDao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Mobile> mobiles = mobileDAO.getAllMobiles();
        Collection<User> users = userDAO.getAllUsers();
        req.setAttribute("mobiles", mobiles);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/AllTablesList.jsp").forward(req, resp);
    }
}
