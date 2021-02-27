package com.tocgic.exam.study_java_basic.week14;

public class BoundedType {
    public static class Box<T> {
        protected T value;
        public void box(T t) {
            value = t;
        }
        public T unbox() {
            T t = value;
            value = null;
            return t;
        }
    }

    public static class NumberBox<T extends Number> extends Box<T> {
        public int intValue() {
            return value.intValue();
        }
    }

    public static void main(String[] args) {
        NumberBox n = new NumberBox<>();
        n.box(new Object());
        try {
            System.out.println(n.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
