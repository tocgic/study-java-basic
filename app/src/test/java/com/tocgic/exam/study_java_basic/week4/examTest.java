package com.tocgic.exam.study_java_basic.week4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class examTest {
    static String userName = null;
    static String address = null;
    static int n = 0;

    private String askQuestion(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Test
    @DisplayName("if")
    void ifTest() {
        String userName = null;
        String address = null;

        if (userName == null)
            System.out.println("userName is null.");;

        if ((address == null) || (address.equals(""))) {
            System.out.println("address is null.");
            System.out.println("or address is empty.");
        }
    }

    @Test
    @DisplayName("if / else")
    void ifElseTest() {
        if (userName != null)
            System.out.println("Hello " + userName);
        else
            userName = askQuestion("What is your name?");
        System.out.println("Hello " + userName + ". Welcome!");
    }

    @Test
    @DisplayName("else 는 가까운 if 과 연결됨")
    void wrongCase1() {
        int i = 0, j = 1, k = 2;
        if (i == j)
            if (j == k)
                System.out.println("i == k");
        else
            System.out.println("i != j"); // wrong. j != k
    }

    @Test
    @DisplayName("{} 을 사용하여 명확하게 처리")
    void fixCase1() {
        int i = 0, j = 1, k = 2;
        if (i == j) {
            if (j == k)
                System.out.println("i == k");
        } else
            System.out.println("i != j");
    }

    @Test
    @DisplayName("else if")
    void elseIf() {
        if (userName == "a") {
            // execute code block #1
        } else {
            if (userName == "b") {
                // execute code block #2
            } else {
                if (userName == "c") {
                    // block #3
                } else {
                    // if all else fail, block #4
                }
            }
        }

        if (userName == "a") {
            // execute code block #1
        } else // { 생략
            if (userName == "b") {
                // execute code block #2
            } else // { 생략
                if (userName == "c") {
                    // execute code block #3
                } else {
                    // if all else fail, execute code block #4
                }
            // } 생략
        // } 생략

        if (userName == "a") {
            // execute code block #1
        } else
        if (userName == "b") {
            // execute code block #2
        } else
        if (userName == "c") {
            // execute code block #3
        } else {
            // if all else fail, execute code block #4
        }

        if (userName == "a") {
            // execute code block #1
        } else if (userName == "b") {
            // execute code block #2
        } else if (userName == "c") {
            // execute code block #3
        } else {
            // if all else fail, execute code block #4
        }
    }

    @Test
    @DisplayName("switch 구문")
    boolean yesOrNo(char response) throws IllegalAccessException {
        switch (n) {
            case 'y':
            case 'Y':
                return true;
            case 'n':
            case 'N':
                return false;
            default:
                throw new IllegalAccessException("must be Y or N");
        }
    }

    @Test
    void forTest() {
        Scanner scanner = new Scanner(System.in);
        String cmd = null;
        for (; !"quit".equals(cmd); ) {
            cmd = scanner.nextLine();
            System.out.println(cmd);
        }
    }

    @Test
    void foreach() {
        List<Integer> numbers = new ArrayList<>();
        for (int number : numbers) {
            System.out.println("number:" + number);
        }
    }

    @Test
    void breakTest() {
        int numrows = 2;
        int numcols = 3;
        Integer data[][] = {{1,2,3}, {4,5,6}};
        TESTFORNULL: if (data != null) {
            for (int row = 0; row < numrows; row++) {
                for (int col = 0; col < numcols; col++) {
                    if (data[row][col] == null)
                        break TESTFORNULL; // treat the array as undefined. }
                }
            }
        }
    }

    @Test
    @DisplayName("continue label;")
    void continueTest() {
        LOOP_I: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j >= 3) {
                    continue LOOP_I;
                }
                System.out.println(i + " " + j);
            }
            System.out.println("loop j done");
        }
    }

}