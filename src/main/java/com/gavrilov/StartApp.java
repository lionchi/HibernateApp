package com.gavrilov;

import com.gavrilov.model.User;
import com.gavrilov.persistence.dao.UserDAOImpl;

public class StartApp {
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.get(1L);

        //userDAO.create(new User());
        System.out.println(user.getLogin());
    }
}
