package ru.mikheev.kirill.servlets;

import ru.mikheev.kirill.dao.IMobileDAO;

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

@WebServlet("/DeleteMobile")
public class DeleteMobileServlet extends HttpServlet {

    private IMobileDAO mobileDAO;

    @Override
    public void init() throws ServletException {
        mobileDAO = (IMobileDAO) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/DeleteMobile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if((Boolean) getServletContext().getAttribute("isAuth")) {
            req.setCharacterEncoding("utf-8");
            String price = req.getParameter("id");
            mobileDAO.deleteMobileById(Integer.valueOf(price));

            resp.sendRedirect(req.getContextPath() + "/AllTablesList");
        }else{
            req.getRequestDispatcher("/PermissionDenied.jsp").forward(req, resp);
        }
    }
}
