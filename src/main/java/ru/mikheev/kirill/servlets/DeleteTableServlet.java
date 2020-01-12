package ru.mikheev.kirill.servlets;

import ru.mikheev.kirill.dao.IMobileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет отвечает за кнопку удаления траблицы mobile
 * @author Kirill Mikheev
 * @version 1.0
 */

@WebServlet("/DeleteTable")
public class DeleteTableServlet extends HttpServlet {

    /**
     * Даошка для взаимодействия с табичкой mobile
     */
    private IMobileDAO mobileDAO;

    /**
     * Получает даошку из атрибутов контекста
     */
    @Override
    public void init() throws ServletException {
        mobileDAO = (IMobileDAO) getServletContext().getAttribute("dao");
        super.init();
    }

    /**
     * Гет завпрос проверяет, авторизирован ли пользователь
     * Если да, то удаление происходит и снова выдается страница главного меню
     * Если нет, то удаление отклоняется и выдается страница с ошибкой
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if((Boolean) getServletContext().getAttribute("isAuth")) {
            mobileDAO.dropTable();
            req.getRequestDispatcher("/MenuPage.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/PermissionDenied.jsp").forward(req, resp);
        }
    }
}
