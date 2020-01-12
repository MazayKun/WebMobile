package ru.mikheev.kirill.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет отвечает за страницу с главным меню
 * @author Kirill Mikheev
 * @version 1.0
 */

@WebServlet("/Menu")
public class MenuServlet extends HttpServlet {

    /**
     * Гет запрос выдает страничку главного меню, так же к запросу прикрепляется уточнение, авторизирован ли пользователь
     * Оно будет отображаться на странице
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isAuth", getServletContext().getAttribute("isAuth"));
        req.getRequestDispatcher("/MenuPage.jsp").forward(req, resp);
    }
}
