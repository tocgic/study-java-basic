# Gradle 을 이용한 JUnit 5 설정



## JUnit 5

```
JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage
```

- Platform : 테스트를 실행하는 런처 제공. TestEngine API 제공
- Juptier : TestEngine API 구현체 (JUnit 5 제공)
- Vintage : 플랫폼에서 JUnit 3 & JUnit 4 기반 테스트 실행



## Gradle 프로젝트 설정

```shell
# gradle init
Starting a Gradle Daemon, 1 stopped Daemon could not be reused, use --status for details

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Scala
  6: Swift
Enter selection (default: Java) [1..6] 3

Split functionality across multiple subprojects?:
  1: no - only one application project
  2: yes - application and library projects
Enter selection (default: no - only one application project) [1..2] 1

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Groovy) [1..2] 2

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit 4) [1..4] 1

Project name (default: exam-test-java-application): 
Source package (default: exam.test.java.application): com.tocgic.exam.test_java_application

> Task :init
Get more help with your project: https://docs.gradle.org/6.7/samples/sample_building_java_applications.html

BUILD SUCCESSFUL in 2m 24s
2 actionable tasks: 2 executed
```

- gradle 을 이용한 프로젝트 설정시
  - Select test framework
    - **JUnit Juptier** 선택
- JUnit 을 설정 안했거나, JUnit 4 이하 설정 된 경우
  - Gradle 의 JUnit 5 설정 참고



## Gradle 의 JUnit 5 사용 설정

- https://docs.gradle.org/current/userguide/java_testing.html#using_junit5

- JUnit 플랫폼 활성화

  - build.gradle.kts

    ```kotlin
    tasks.named<Test>("test") {
        useJUnitPlatform()
    }
    ```

- JUnit Jupiter 종속성 설정

  - build.gradle.kts

    ```kotlin
    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }
    ```

- JUnit Vintage 종속성 설정 (플랫폼에서 레거시 JUnit 3/4 실행 시)
  - build.gradle.kts

    ```kotlin
    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
        testCompileOnly("junit:junit:4.13")
        testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
    }
    ```



## IntelliJ 추가 설정

- JUnit 5 의 Annotation 중, `@DisplayName` 이 동작 하지 않는 경우
  - Build, Execution, Deployment > Build Tools > Gradle 이동
    - Run tests using 변경
      - Gradle -> **IntelliJ IDEA**

