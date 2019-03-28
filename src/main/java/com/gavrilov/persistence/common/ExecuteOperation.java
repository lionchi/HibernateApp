package com.gavrilov.persistence.common;

import javax.persistence.EntityManager;

@Deprecated
@FunctionalInterface
public interface ExecuteOperation {
    Object execute(EntityManager entityManager);
}
