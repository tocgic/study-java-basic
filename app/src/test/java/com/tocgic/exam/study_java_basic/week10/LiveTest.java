package com.tocgic.exam.study_java_basic.week10;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * - 책소개
 *   - 자바 병렬 프로그래밍 (에이콘)
 *   - 톰캣 최종분석 ()
 *      - 톰캣같은 서버를 만들어보는 내용
 *
 * - IntelliJ tip
 * - week10
 *   - interrupt -> 종료 아님. 깨우는것?
 *   - volatile : 한스레드만 write 를 한다는 가정이 있어야 함
 *   - Dashboard -> 멀티 처리 : multiThread()
 *   - Concurrency
 *     - Actor model - Akka
 *     - STM (Software transactional model) - Clojure
 *   - 용어
 *     - critical path (임계영역)
 *       - 동시실행하는 항목 중 가장 오래 걸리는 항목 (해당 구간 중, 가장 오래 걸리는 항목)
 *       -> 전체 수행시간을 줄이기 위해 가장 우선적으로 개선할 부분
 *     - race condition
 *   - Tools
 *     - VisualVM - Thread dump 를 뜰 수 있음
 *     - heap dump : 메모리 덤프
 *     - thread dump
 *
 * - 11주차 과제 설명
 *   - enum 정의하는 방법
 *   - enum이 제공하는 메소드 (values()와 valueOf())
 *   - java.lang.Enum
 *   - EnumSet
 */
public class LiveTest {
    @Test
    void multiThread() {

        try {
            ExecutorService service = Executors.newFixedThreadPool(8);
            CountDownLatch latch = new CountDownLatch(15);
            service.execute(new Runnable() {
                @Override
                public void run() {
                    // TODO: 2021/01/23

                    latch.countDown();
                }
            });
            latch.await();
            service.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
