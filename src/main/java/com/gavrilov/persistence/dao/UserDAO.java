package com.gavrilov.persistence.dao;

import com.gavrilov.model.User;

import java.util.List;

public interface UserDAO {
    User create(User newEmployee);

    User get(Long employeeId);

    User update(User employee);

    List<User> list();

    long count();

    void delete(int existingEmployee);
}
