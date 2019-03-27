package com.gavrilov;

import com.gavrilov.model.User;
import com.gavrilov.persistence.dao.BasicDAO;
import com.gavrilov.persistence.dao.UserDAO;
import com.gavrilov.persistence.dao.UserDAOImpl;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class StartApp {
    public static void main(String[] args) {
        initWeldContainer();
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.create(new User());
        User user = userDAO.get(1L);
        System.out.println(user.getLogin());
    }

    private static void initWeldContainer() {
        Weld weld = new Weld();
        WeldContainer container = weld
                .addPackages(StartApp.class.getPackage())
                .addBeanClasses(BasicDAO.class, UserDAO.class)
                .initialize();
        BasicDAO basicDAO = container.instance().select(BasicDAO.class).get();
        System.out.println();
        /*SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        initializer.addPackages(StartApp.class.getPackage());
        SeContainer container = initializer.initialize();*/
    }
}
