package com.tocgic.exam.study_java_basic.week14.generic2;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDao<E extends Entity<K>, K> {
    private Class<E> entityClass;

    public GenericDao() {
        // Generic 은 Erasure 가 되는데, Entity 클래스 정보 확인 방법
        this.entityClass = (Class<E>)(((ParameterizedType)this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
    }
//    public GenericDao(Class<E> entityClass) {
//        this.entityClass = entityClass;
//    }
    public Class<E> getEntityClass() {
        return entityClass;
    }

    private Map<K, E> datasource = new HashMap<>();

    public void save(E e) {
        datasource.put(e.getId(), e);
    }

    public void delete(E entity) {
        datasource.remove(entity.getId());
    }

    public void delete(K id) {
        datasource.remove(id);
    }

    public List<E> findAll() {
        return new ArrayList<>(datasource.values());
    }

    public E findById(K id) {
        return datasource.get(id);
    }
}
