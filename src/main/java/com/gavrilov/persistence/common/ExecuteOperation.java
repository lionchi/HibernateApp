package com.gavrilov.persistence.common;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface ExecuteOperation {
    Object execute(EntityManager entityManager);
}
