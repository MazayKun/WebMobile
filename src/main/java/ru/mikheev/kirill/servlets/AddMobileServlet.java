package ru.mikheev.kirill.servlets;

import ru.mikheev.kirill.dao.IMobileDAO;
import ru.mikheev.kirill.pojo.Mobile;

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

@WebServlet("/AddMobile")
public class AddMobileServlet extends HttpServlet {

    //private IMobileDAO mobileDao;

    @Override
    public void init() throws ServletException {
        //mobileDao = (IMobileDAO) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("AddMobilePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String model = req.getParameter("model");
        String price = req.getParameter("price");
        Mobile mobile = new Mobile(0, model, Integer.valueOf(price));
        //mobileDao.addMobile(mobile);

        //resp.sendRedirect(req.getContextPath() + "/allmobiles");
    }
}
