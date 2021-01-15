package com.tocgic.exam.study_java_basic.week9;

public interface CloseableNotException extends AutoCloseable {
    @Override
    void close();
}
