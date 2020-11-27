package com.tocgic.exam.study_java_basic.week3;

import org.junit.Test;

public class ComparisonOperatorTest {
    @Test
    public void equals() {
        int int4 = 4;
        float float4 = 4f;
        System.out.println(int4 == float4); // true
        String name1 = "name";
        String name2 = "name";
        System.out.println(name1 == name2); // true
        String name3 = new String("name");
        String name4 = new String("name");
        System.out.println(name3 == name4); // false

        boolean isBig = int4 > float4;
    }
}
