package com.gavrilov.persistence.dao;

import com.gavrilov.model.Role;

import java.util.List;

public interface RoleDAO {
    Role create(Role newEmployee);

    Role get(Long employeeId);

    Role update(Role employee);

    List<Role> list();

    long count();

    void delete(int existingEmployee);
}
