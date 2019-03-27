package com.gavrilov.persistence.dao;

import com.gavrilov.model.User;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

import static com.gavrilov.persistence.common.ExecuteUtils.transactional;

public class UserDAOImpl implements UserDAO {

    public User create(@Valid User user) {
        return (User) transactional(entityManager -> {
                    entityManager.persist(user);
                    return user;
                },
                "Не удалось создать нового пользователя");
    }

    public User get(Long employeeId) {
        return (User) transactional(entityManager ->
                entityManager.find(User.class, employeeId), "Такого пользователя нет");
    }

    public User update(@Valid User employee) {
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
