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

@WebServlet("/CreateTable")
public class CreateTableServlet extends HttpServlet {

    private IMobileDAO mobileDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
