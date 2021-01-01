package com.tocgic.exam.study_java_basic.week7;
import com.tocgic.exam.study_java_basic.week7_sub.Print;
import static com.tocgic.exam.study_java_basic.week7_sub.Print.staticPrint;
import static com.tocgic.exam.study_java_basic.week7_sub.Print.NAME;

public class ImportTest {
    public void callMethod() {
        new Print().print();
        new com.tocgic.exam.study_java_basic.week7_sub.Print2().print();
    }

    public void callStaticMethod() {
        Print.staticPrint();
        com.tocgic.exam.study_java_basic.week7_sub.Print2.staticPrint();
    }

    public void callStaticImported() {
        staticPrint();
        System.out.println("NAME : " + NAME);
    }
}
