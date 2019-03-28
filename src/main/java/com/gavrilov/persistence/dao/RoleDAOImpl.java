package com.gavrilov.persistence.dao;

import com.gavrilov.model.Role;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RoleDAOImpl implements RoleDAO {

    @Inject
    private EntityManager entityManager;
    @Inject
    private BasicDAO basicDAO;

    @Override
    public Role create(Role newEmployee) {
        return null;
    }

    @Override
    public Role get(Long employeeId) {
        return entityManager.find(Role.class, employeeId);
    }

    @Override
    public Role update(Role employee) {
        return null;
    }

    @Override
    public List<Role> list() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(int existingEmployee) {

    }
}
