package com.tocgic.exam.study_java_basic.week14.generic3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item<E> {
    private Object[] objects = new Object[1];
    private E[] array = (E[]) new Object[1];
    private List<E> list = new ArrayList<>();

    public void add(E item) {
        objects[1] = item;
        array[1] = item;

    }

    public E[] toArray() {
        return array;
    }
    public E[] toArrayObjects() {
        return list.toArray((E[]) new Object[0]);
//        return (E[]) objects;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        String[] stringArray = strings.toArray(new String[0]);
        System.out.println("stringArray:" + Arrays.toString(stringArray));
        String[] target1 = new String[10];
        String[] target2 = strings.toArray(target1);
        System.out.println("target1:" + Arrays.toString(target1));
        System.out.println("target2:" + Arrays.toString(target2));
        assert target1 == target2;
        System.out.println(target1 + ", " + target2);
    }

    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        @SuppressWarnings("unchecked")
        T[] copy = ((Object)newType == (Object)Object[].class)
                ? (T[]) new Object[newLength]
                : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }
}
