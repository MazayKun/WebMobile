package ru.mikheev.kirill.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет отвечает за страничку хеллоу
 * Это просто страничка с надписью хеллоу
 * (Жалко было удалять, все таки самый первый сервлет^^ )
 *
 * @author Kirill Mikheev
 * @version 1.0
 */

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {

    /**
     * Гет завпрос выдает эту самую страничку
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("HelloPage.jsp").forward(req, resp);
    }
}
