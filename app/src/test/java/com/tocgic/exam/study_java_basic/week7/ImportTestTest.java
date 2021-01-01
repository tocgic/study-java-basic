package com.tocgic.exam.study_java_basic.week7;

import org.junit.jupiter.api.Test;

class ImportTestTest {
    @Test
    void name() {
        ImportTest importTest = new ImportTest();
        importTest.callMethod();
        importTest.callStaticMethod();
        importTest.callStaticImported();
    }
}