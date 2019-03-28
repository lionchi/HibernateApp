package com.gavrilov;

import com.gavrilov.model.Role;
import com.gavrilov.model.User;
import com.gavrilov.persistence.dao.BasicDAOImpl;
import com.gavrilov.persistence.dao.RoleDAOImpl;
import com.gavrilov.persistence.dao.UserDAOImpl;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;


public class StartApp {
    public static void main(String[] args) {
        initWeldContainer();
    }

    private static void initWeldContainer() {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        initializer.addPackages(StartApp.class.getPackage());
        SeContainer container = initializer.initialize();

        BasicDAOImpl basicDAO = container.select(BasicDAOImpl.class).get();

        UserDAOImpl userDAO = container.select(UserDAOImpl.class).get();
        User user = userDAO.get(1L);
        System.out.println(user.getLogin());

        RoleDAOImpl roleDAO = container.select(RoleDAOImpl.class).get();
        Role role = roleDAO.get(2L);
        System.out.println(role.getNameRole());
    }
}
