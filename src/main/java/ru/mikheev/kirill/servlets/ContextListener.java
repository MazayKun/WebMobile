package ru.mikheev.kirill.servlets;

import ru.mikheev.kirill.dao.IMobileDAO;

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

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("dao", mobileDAO);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.removeAttribute("dao");
    }
}
