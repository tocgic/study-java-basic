package com.tocgic.exam.study_java_basic.week7;

import org.junit.jupiter.api.Test;

class ClazzTest {
    @Test
    void name() {
        System.out.println("getSimpleName() : " + Clazz.class.getSimpleName());
        System.out.println("getName() : " + Clazz.class.getName());
        System.out.println("getCanonicalName() : " + Clazz.class.getCanonicalName());
        System.out.println("getTypeName() : " + Clazz.class.getTypeName());
    }

    @Test
    void name2() {
        printNamesForClass(
                int.class,
                "int.class (primitive)");
        printNamesForClass(
                String.class,
                "String.class (ordinary class)");
        printNamesForClass(
                java.util.HashMap.SimpleEntry.class,
                "java.util.HashMap.SimpleEntry.class (nested class)");
        printNamesForClass(
                new java.io.Serializable(){}.getClass(),
                "new java.io.Serializable(){}.getClass() (anonymous inner class)");
        printNamesForClass(
                String[].class,
                "String[].class (array class)");
    }

    private void printNamesForClass(final Class<?> clazz, final String label) {
        System.out.println(label + ":");
        System.out.println("    getName():          " + clazz.getName());
        System.out.println("    getCanonicalName(): " + clazz.getCanonicalName());
        System.out.println("    getSimpleName():    " + clazz.getSimpleName());
        System.out.println("    getTypeName():      " + clazz.getTypeName()); // added in Java 8
        System.out.println();
    }
}