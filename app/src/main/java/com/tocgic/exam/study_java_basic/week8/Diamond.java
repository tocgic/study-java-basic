package com.tocgic.exam.study_java_basic.week8;

import com.tocgic.exam.study_java_basic.week8.diamond.Bar;
import com.tocgic.exam.study_java_basic.week8.diamond.Foo;

public class Diamond implements Foo, Bar {
    @Override
    public void printName() {
        System.out.println("Diamond");
    }

    @Override
    public void print() {
        Foo.super.print();
    }

    public static void main(String[] args) {
        new Diamond().print();
    }
}
