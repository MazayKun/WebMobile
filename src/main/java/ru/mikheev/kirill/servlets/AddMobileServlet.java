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
 * Сервлет отвечает за страничку добавления нового мобильника в таблицу mobile
 * @author Kirill Mikheev
 * @version 1.0
 */

@WebServlet("/AddMobile")
public class AddMobileServlet extends HttpServlet {

    /**
     * Даошка для взаимодействия с таблицей mobile
     */
    private IMobileDAO mobileDao;

    /**
     * При инициализации получает даошку, которая хранится в контексте
     */
    @Override
    public void init() throws ServletException {
        mobileDao = (IMobileDAO) getServletContext().getAttribute("dao");
        super.init();
    }

    /**
     * Гет запрос просто отрисоывает страничку
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("AddMobilePage.jsp").forward(req, resp);
    }

    /**
     * Пост запрос отвечает за добавление мобильника с данными, которые пользовтель ввел на станичке
     * Он проверяет авторизовался ли пользовтель, если да, то он имеет право добавить, если нет, то кидает страницу с ошибкой
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if((Boolean) getServletContext().getAttribute("isAuth")) {
            req.setCharacterEncoding("utf-8");
            String model = req.getParameter("model");
            String price = req.getParameter("price");
            Mobile mobile = new Mobile(0, model, Integer.valueOf(price));
            mobileDao.addMobile(mobile);
            resp.sendRedirect(req.getContextPath() + "/AllTablesList");
        }else {
            req.getRequestDispatcher("PermissionDenied.jsp").forward(req, resp);
        }
    }
}
