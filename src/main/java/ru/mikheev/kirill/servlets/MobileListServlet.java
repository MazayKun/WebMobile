package ru.mikheev.kirill.servlets;

import ru.mikheev.kirill.dao.IMobileDAO;
import ru.mikheev.kirill.pojo.Mobile;

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

@WebServlet("/MobileList")
public class MobileListServlet extends HttpServlet {

    private IMobileDAO mobileDAO;

    @Override
    public void init() throws ServletException {
        mobileDAO = (IMobileDAO) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Mobile> mobiles = mobileDAO.getAllMobiles();
        req.setAttribute("mobiles", mobiles);
        req.setAttribute("PageTitle", "Mobiles");
        req.getRequestDispatcher("/MobileList.jsp").forward(req, resp);
    }
}
