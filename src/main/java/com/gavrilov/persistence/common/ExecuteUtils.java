package com.gavrilov.persistence.common;

import com.gavrilov.persistence.PersistenceSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

@Deprecated
public class ExecuteUtils {
    private static final Logger log = LoggerFactory.getLogger(ExecuteUtils.class);

    public static Object transactional(final ExecuteOperation executeOperation, String errorMessage) {
        EntityManager entityManager = PersistenceSingleton.instance.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            final Object returnedData = executeOperation.execute(entityManager);
            transaction.commit();
            return returnedData;
        } catch (RollbackException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            log.error(errorMessage, e);
            throw new IllegalStateException(errorMessage, e);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
