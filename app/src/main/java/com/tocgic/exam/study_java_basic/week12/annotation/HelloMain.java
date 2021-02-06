package com.tocgic.exam.study_java_basic.week12.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class HelloMain {
    public static void main(String[] args) {
        System.out.println("\n*** MyHelloController, Annotation ***");
        Annotation[] annotations = MyHelloController.class
//                .getAnnotations();
                .getDeclaredAnnotations(); //@Inherited 무시하고 보여줌 => 해당 클래스에 존재하는 애노테이션만 가져옴
        for (Annotation annotation : annotations) {
//            System.out.println(annotation);
        }

        System.out.println("\n*** HelloController, fields ***");
//        Field[] fields = HelloController.class.getFields(); //public 만..
        Field[] fields = HelloController.class.getDeclaredFields(); // 선언되어 있는 모든 필드
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("\n*** MyHelloController, fields ***");
        Field[] myFields = MyHelloController.class.getFields();
//        Field[] myFields = MyHelloController.class.getDeclaredFields(); // 선언되어 있는 모든 필드
        for (Field field : myFields) {
            System.out.println(field);
        }
    }
}
