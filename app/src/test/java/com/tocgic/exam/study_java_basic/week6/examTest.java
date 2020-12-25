package com.tocgic.exam.study_java_basic.week6;

import com.tocgic.exam.study_java_basic.week6.overriding.Animal;
import com.tocgic.exam.study_java_basic.week6.overriding.Dog;
import org.junit.jupiter.api.Test;

class examTest {
    @Test
    void constructorChaining() {
        System.out.println("- create Cat");
        new com.tocgic.exam.study_java_basic.week6.constructor_chaining.Cat();
        System.out.println("- create Dog");
        new com.tocgic.exam.study_java_basic.week6.constructor_chaining.Dog();
    }

    @Test
    void staticOverridingTest() {
        Animal.print();
        Dog.print();
        Animal.print2();
        Dog.print2();

        Dog dog = new Dog();
        dog.print();
        ((Animal)dog).print();
        dog.print2();
        ((Animal)dog).print2();
    }

    @Test
    void overridingTest() {
        Dog dog = new Dog();
        dog.callMove();
    }

    @Test
    void finalTest() {
        final int number;
        String name = "jj";
        System.out.println("name : " + name);
    }
}