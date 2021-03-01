package com.tocgic.exam.study_java_basic.week14.generic2;

public class Entity<K> {
    protected K id;
    protected K getId() {
        return id;
    }

    public static <T extends Entity<K>, K> T of(Class<T> classOfT, K id) {
        try {
            T instance = classOfT.getDeclaredConstructor().newInstance();
            instance.id = id;
            return instance;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
