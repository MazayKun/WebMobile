package ru.mikheev.kirill.servlets;

import ru.mikheev.kirill.dao.IMobileDAO;
import ru.mikheev.kirill.dao.IUserDAO;
import ru.mikheev.kirill.pojo.Mobile;
import ru.mikheev.kirill.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Сервлет отвечает за страничку, которая показывает содержимое всех табличек (кроме столбца паролей у пользователей)
 * @author Kirill Mikheev
 * @version 1.0
 */

@WebServlet("/AllTablesList")
public class AllTablesServlet extends HttpServlet {

    /**
     * Даошки для взаимодейтсвия с табличками
     */
    private IMobileDAO mobileDAO;
    private IUserDAO userDAO;

    /**
     * Получает из контекста даошки для взаимодейтсивя с табличками
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        mobileDAO = (IMobileDAO) getServletContext().getAttribute("dao");
        userDAO = (IUserDAO) getServletContext().getAttribute("userDao");
        super.init();
    }

    /**
     * Отправляет списки объектов из таблиц для заполнения страницы и выдает ее пользователю
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Mobile> mobiles = mobileDAO.getAllMobiles();
        Collection<User> users = userDAO.getAllUsers();
        req.setAttribute("mobiles", mobiles);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/AllTablesList.jsp").forward(req, resp);
    }
}
