package ru.mikheev.kirill.servlets;

import ru.mikheev.kirill.dao.IMobileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет отвечает за страничку удаления мобильника из таблицы mobile
 * @author Kirill Mikheev
 * @version 1.0
 */

@WebServlet("/DeleteMobile")
public class DeleteMobileServlet extends HttpServlet {

    /**
     * Даошка для взаимодейтвия с табличкой mobile
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
     * Гет запрос выдает страничку с полем на ввод айдишника удаляемого мобильника
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/DeleteMobile.jsp").forward(req, resp);
    }

    /**
     * Пост запрос несет айдишник мобильника, который нужно удалить
     * Если пользователь авторизован, то все роходит успешно и выдается страничка с содержимым всех таблиц
     * Если не авторизован, то удаление не проходит, а в ответ кидается страничка с ошибкой
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if((Boolean) getServletContext().getAttribute("isAuth")) {
            req.setCharacterEncoding("utf-8");
            String price = req.getParameter("id");
            mobileDAO.deleteMobileById(Integer.valueOf(price));

            resp.sendRedirect(req.getContextPath() + "/AllTablesList");
        }else{
            req.getRequestDispatcher("/PermissionDenied.jsp").forward(req, resp);
        }
    }
}
