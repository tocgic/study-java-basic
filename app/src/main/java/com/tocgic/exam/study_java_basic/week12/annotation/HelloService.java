package com.tocgic.exam.study_java_basic.week12.annotation;

/**
 * ServiceLoader
 * jar 만 교체 했을때, 인터페이스의 구현체를 가져올 수 있음
 *
 * 어떻게 찾는가?
 * - jar 파일 안에..
 *  - resources/META-INF/services/{인터페이스 full 패키지 경로로 파일 생성}
 *      - 파일 안에 : 구현채 full 패키지 경로
 * - 사용
 *  - ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
 *    for (HelloService helloService : loader) {
 *        System.out.println(helloService.hello());
 *    }
 */
public interface HelloService {
    String hello();
}
