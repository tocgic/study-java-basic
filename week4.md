# 4주차 과제: 제어문

> # 목표
>
> 자바가 제공하는 제어문을 학습하세요.
>
> # 학습할 것 (필수)
>
> 선택문
> 반복문
>
> # 과제 (옵션)
>
> ## 과제 0. JUnit 5 학습하세요.
>
> - 인텔리J, 이클립스, VS Code에서 JUnit 5로 테스트 코드 작성하는 방법에 익숙해 질 것.
> - 이미 JUnit 알고 계신분들은 다른 것 아무거나!
> - [더 자바, 테스트](https://www.inflearn.com/course/the-java-application-test?inst=86d1fbb8) 강의도 있으니 참고하세요~
>
> ## 과제 1. live-study 대시 보드를 만드는 코드를 작성하세요.
>
> - 깃헙 이슈 1번부터 18번까지 댓글을 순회하며 댓글을 남긴 사용자를 체크 할 것.
> - 참여율을 계산하세요. 총 18회에 중에 몇 %를 참여했는지 소숫점 두자리가지 보여줄 것.
> - [Github 자바 라이브러리](https://github-api.kohsuke.org/)를 사용하면 편리합니다.
> - 깃헙 API를 익명으로 호출하는데 제한이 있기 때문에 본인의 깃헙 프로젝트에 이슈를 만들고 테스트를 하시면 더 자주 테스트할 수 있습니다.
>
> ## 과제 2. LinkedList를 구현하세요.
>
> - LinkedList에 대해 공부하세요.
> - 정수를 저장하는 ListNode 클래스를 구현하세요.
> - ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
> - ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
> - boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.
>
> ## 과제 3. Stack을 구현하세요.
>
> - int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
> - void push(int data)를 구현하세요.
> - int pop()을 구현하세요.
>
> ## 과제 4. 앞서 만든 ListNode를 사용해서 Stack을 구현하세요.
>
> - ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
> - void push(int data)를 구현하세요.
> - int pop()을 구현하세요.
>
> ## 과제 5. Queue를 구현하세요.
>
> - 배열을 사용해서 한번
> - ListNode를 사용해서 한번.
>
> # 마감일시
>
> 2020년 12월 12일 토요일 오후 1시까지.



## 선택문



#### if / else

##### if

if 문은 Java가 결정을 내리거나보다 정확하게는 조건부로 문을 실행할 수 있도록하는 기본 제어 문.
if 문에는 표현식(expression) 과 구문(statement) 로 구성 되며,

> **if (**조건**)** 구문

표현식, 즉 조건이 만족(true) 하면 구문 을 수행 함.

구문이 단일 명령(;)이 아닌경우, 코드블럭 `{}` 을 사용하여 묶을 수 있음.

```java
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
```

```
userName is null.
address is null.
or address is empty.
```



##### if / else

> **if (**조건A**)** 구문A **else** 구문B

조건A 가 **참** 인 경우 **구문A 를 수행**하고, **거짓**인 경우 **구문 B 를 수행**

```java
    @Test
    @DisplayName("if / else")
    void ifElseTest() {
        if (userName != null)
            System.out.println("Hello " + userName);
        else
            userName = askQuestion("What is your name?");
        System.out.println("Hello " + userName + ". Welcome!");
    }
```

```
What is your name?
aria //사용자 입력
Hello aria. Welcome!
```

##### *주의사항

```java
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
```

> else 는 **가장 가까운 if** 와 연결 됨
>
> 명확하게 하기 위해서 {} 사용 할 수 있음

```java
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
```



##### else if

> **if (**조건A**)** 구문A **else** 구문B
> **if (**조건A**)** 구문A **else if (**조건C**)** 구문C 

조건A 가 거짓인 경우, 다른 조건 비교가 필요하면, **구문B 위치에 다시 if 문을 추가 할 수 있음** (반복 가능)

```java
    @Test
    @DisplayName("else if")
    void elseIf() {
        // STEP 1
        if (userName == "a") {
            // block #1
        } else {
            if (userName == "b") {
                // block #2
            } else {
                if (userName == "c") {
                    // block #3
                } else {
                    // if all else fail, block #4
                }
            }
        }

      
        // STEP 2 : {} 생략        
        if (userName == "a") {
            
        } else // { 생략
            if (userName == "b") {
                
            } else // { 생략
                if (userName == "c") {
                    
                } else {
                    
                }
            // } 생략
        // } 생략

      
        // STEP 3 : 라인 정렬
        if (userName == "a") {
            
        } else
        if (userName == "b") {
            
        } else
        if (userName == "c") {
            
        } else {
            
        }

      
        // STEP 4 : else if 연결
        if (userName == "a") {

        } else if (userName == "b") {

        } else if (userName == "c") {

        } else {

        }
    }
```



#### switch

- 한 조건에 대해, 다양한 경우에 따른 분기 처리
- 표현식(조건) : int, short, char, byte (primitive type, wrapper type 가능), String, enum
- 주의사항
  - case label 의 수행 끝처리는 break, return, throw 를 사용할 수 있음
  - case label 의 수행 끝은 break 를 통해 stop 이 되어야 다음 case label 에 대한 구문이 수행되지 않음
  - 부동 소수점 및 부울 유형은 지원되지 않으며 정수형인 long도 지원되지 않음
  - 각 case label 과 관련된 값은 컴파일러가 평가할 수있는 상수 값 또는 상수 표현식이어야 함
  - case label 값은 스위치 표현식에 사용되는 데이터 유형의 범위 내에 있어야 함
  - case label 은 중복 될 수 없음 : error: duplicate case label
  - default 는 생략 가능 하지만, 2개이상 존재 할 수 없다

```java
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
```





## 반복문

#### while

```java
while (expression) {
    statement 
}
```

- 동작 방식 : expression 판단 후 statement 수행
  - expression 이 true 인 경우, 블럭의 statement 를 수행 후, 다시 expression 의 조건 확인
  - expression 이 false 인 경우, 블럭의 statement 를 수행하지 않고, 종료
- statement 는 수행 안될 수도 있음

#### do

```java
do {
    statement
} while (expression);
```

- 동작 방식 : statement 수행 후 expression 판단
- 1회 이상 statement 수행 됨

#### for

```java
for (initialize; test; update) {
    statement
}
```

- initialize; test; update 영역은 `;` 으로 구분

- initialize 는 처음 한번만 수행

- 동작순서

  - initialize
    - test : 조건이 거짓이면, 블럭 종료
    - statement
    - update

- while 문의 변형

  ```java
  initialize
  while (test) {
     statement
     update
  }
  ```

- initialize 에서 정의된 로컬 변수는 for 문의 block scope 를 따른다

- test 구분에서 연산 사용의 주의

  - 조건 판단시, collection size() 를 매번 호출하여 비교 하는 것 vs collection size() 를 변수로 받아 비교

  

#### foreach (향상된 for 문)

```java
for (declaration : expression)
   statement
```

- Object collection 에 대한 반복시 for 문의 불필요한 부분을 개선

- 배열 및 컬렉션의 요소를 반복 처리시 유용

- foreach 는 update 영역의 counter 를 둘 수 없기 때문에, 제한적 사용

  - 배열 및 컬렉션의 요소를 역순으로 반복 할 수 없음

  - 특정 위치의 요소를 가져올 수 없음 (인덱스가 없음으로)

  - 컬렉션의 항목화를 위한 Iterator 객체를 얻을 수 없음 => get() 을 사용할 수 없음

    

#### break

- Java 인터프리터가 포함 된 **문의 끝** 으로 **즉시 이동**

- label 을 사용한 break 가능

  ```java
  break {레이블};
  ```

   이 형식으로 사용되는 경우 break는 Java 인터프리터가 **명명 된 블록**을 **즉시 종료**

  ```java
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
  ```

  

#### continue

- 루프의 현재 반복을 종료하고 다음 반복을 시작

- while, do 또는 for 루프 내에서만 사용 가능

- continue;

  - 가장 안쪽의 루프가 새 반복을 시작

- continue label;

  - 레이블로 명명 된 루프가 새 반복을 시작

    ```java
        @Test
        @DisplayName("continue label;")
        void continueTest() {
            LOOP_I: for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (j >= 3) {
                        continue LOOP_I;
                    }
                    System.out.println(i + " " + j);
                }
                System.out.println("loop j done");
            }
        }
    ```

    ```
    0 0
    0 1
    0 2
    1 0
    1 1
    1 2
    2 0
    2 1
    2 2
    ```

- **for** vs **while** 에서 countinue **동작 차이**

  - [for 문] countinue 수행시, `update 를 수행` 후, test 조건으로 진행
  - [while] countinue 수행시, test 조건으로 진행



> 참조.
>
> Java in a Nutshell, 7th Edition

