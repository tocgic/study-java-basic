package com.tocgic.exam.study_java_basic.week9;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TryCatchFinalTest {
    @Test
    void syntaxTest() {
//        try {
//            System.out.println("try 단독 사용");
//        }
    }

    @Test
    void syntaxResourceDeclarationsTest() {
        try (
                CloseableNotException closeableNotException = () -> {
                    System.out.println("closeableNotException, close() 호출 됨");
                }
        ) {
            System.out.println("closeableNotException : " + closeableNotException);
        }
    }

    @Test
    void syntaxTWRTest() {
        try (
                AutoCloseable autoCloseable = () -> {
                    System.out.println("close() 호출 됨");
                    throw new Exception("close() 처리중 예외 발생");
                }
        ) {
            System.out.println("autoCloseable:" + autoCloseable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void finallyTest() {
        FileInputStream is = null;
        try {
            is = new FileInputStream("file.txt");
            // is 사용
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @Test
    void finallyTWRTest() {
        try (
                FileInputStream is = new FileInputStream("file.txt")
        ){
            // is 사용
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void throwTest(double number) {
        try {
            if (number > Integer.MAX_VALUE) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    void throwsTest(double number) throws Exception {
        if (number > Integer.MAX_VALUE) {
            throw new Exception("너무 큽니다.");
        }
    }

    @Test
    void throwsCallTest() {
        try {
            throwsTest(Double.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void throwsTest2() throws FileNotFoundException, EOFException {
        FileInputStream fio = new FileInputStream("file.txt");
        throw new EOFException();
    }

    @Test
    void throwsTest3() throws IOException {
        if (!new File("file.txt").exists()) {
            throw new FileNotFoundException();
        }
        throw new EOFException();
    }

    @Test
    void catchTest() {
        try {
            if (!new File("file.txt").exists()) {
                throw new FileNotFoundException();
            }
            if (!new File("file.txt").exists()) {
                throw new EOFException();
            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException eof) {
            eof.printStackTrace();
        }
    }
}