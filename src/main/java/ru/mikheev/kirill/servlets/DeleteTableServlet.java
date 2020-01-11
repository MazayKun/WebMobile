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

@WebServlet("/DeleteTable")
public class DeleteTableServlet extends HttpServlet {

    private IMobileDAO mobileDAO;

    @Override
    public void init() throws ServletException {
        mobileDAO = (IMobileDAO) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mobileDAO.dropTable();
        req.getRequestDispatcher("/MenuPage.jsp").forward(req, resp);
    }
}
