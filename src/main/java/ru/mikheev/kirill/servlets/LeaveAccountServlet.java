package ru.mikheev.kirill.servlets;

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

@WebServlet("/Quit")
public class LeaveAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().setAttribute("isAuth", false);
        resp.sendRedirect(req.getContextPath() + "/Menu");
    }
}