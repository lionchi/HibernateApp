package com.gavrilov.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerFactoryProducer {
    @Produces
    @ApplicationScoped
    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("com.gavrilov.persistence");
    }

    public void onShutdown(@Disposes EntityManagerFactory emf) {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
