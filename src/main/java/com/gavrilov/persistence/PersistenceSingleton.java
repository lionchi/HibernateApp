package com.gavrilov.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Deprecated
public enum PersistenceSingleton {
    instance;

    private EntityManagerFactory entityManagerFactory;

    private EntityManagerFactory setupEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("com.gavrilov.persistence");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = setupEntityManagerFactory();
        }
        return entityManagerFactory;
    }

    public void destroy() {
        entityManagerFactory.close();
    }
}
