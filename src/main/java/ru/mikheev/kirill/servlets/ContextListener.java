package ru.mikheev.kirill.servlets;

import ru.mikheev.kirill.dao.IMobileDAO;
import ru.mikheev.kirill.dao.IUserDAO;
import ru.mikheev.kirill.pojo.User;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Kirill Mikheev
 * @version 1.0
 */

@WebListener
public class ContextListener implements ServletContextListener {

    @Inject
    IMobileDAO mobileDAO;
    @Inject
    IUserDAO userDAO;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Boolean isAuth = false;
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("dao", mobileDAO);
        servletContext.setAttribute("userDao", userDAO);
        servletContext.setAttribute("isAuth", isAuth);

        userDAO.createTable();
        userDAO.addUser(new User(0, "root", "0000", "null@null.null", "000000"));
        userDAO.addUser(new User(0, "normal_user", "0000", "normal_email@normal_mail_service.normal_location_domain", "123456"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.removeAttribute("dao");
        servletContext.removeAttribute("isAuth");
        userDAO.dropTable();
    }
}
