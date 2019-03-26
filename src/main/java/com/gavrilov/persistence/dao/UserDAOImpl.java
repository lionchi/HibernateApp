package com.gavrilov.persistence.dao;

import com.gavrilov.model.User;

import javax.inject.Inject;
import java.util.List;

import static com.gavrilov.persistence.common.ExecuteUtils.transactional;

public class UserDAOImpl implements UserDAO {

    @Inject
    private BasicDAO basicDAO;

    public User create(User newEmployee) {
        basicDAO.create(newEmployee);
        return newEmployee;
    }

    public User get(Long employeeId) {
        return (User) transactional(entityManager ->
                entityManager.find(User.class, employeeId), "Такого пользователя нет");
    }

    public User update(User employee) {
        return null;
    }

    public List<User> list() {
        return null;
    }

    public long count() {
        return 0;
    }

    public void delete(int existingEmployee) {

    }
}
