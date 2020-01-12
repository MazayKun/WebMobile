package ru.mikheev.kirill.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет отвечает за кнопку разлогинивания
 * @author Kirill Mikheev
 * @version 1.0
 */

@WebServlet("/Quit")
public class LeaveAccountServlet extends HttpServlet {

    /**
     * Гет запрос переводит атрибут, отвечающий за проверку авторизации в состояние false и снова выдает страницу главного меню
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        getServletContext().setAttribute("isAuth", false);
        resp.sendRedirect(req.getContextPath() + "/Menu");
    }
}
