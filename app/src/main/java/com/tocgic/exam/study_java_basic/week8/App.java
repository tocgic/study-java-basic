package com.tocgic.exam.study_java_basic.week8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("apple");
        name.add("banana");
        name.add("grape");

        name.forEach(System.out::println);

        Spliterator<String> spliterator = name.spliterator();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("\n");

        Spliterator<String> spliterator1 = name.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("---------------------------");
        while (spliterator2.tryAdvance(System.out::println));

    }
}
