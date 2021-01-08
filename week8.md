# 8주차 과제: 인터페이스

> - # 목표
>
>   자바의 인터페이스에 대해 학습하세요.
>
>   # 학습할 것 (필수)
>
>   - 인터페이스 정의하는 방법
>   - 인터페이스 구현하는 방법
>   - 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
>   - 인터페이스 상속
>   - 인터페이스의 기본 메소드 (Default Method), 자바 8
>   - 인터페이스의 static 메소드, 자바 8
>   - 인터페이스의 private 메소드, 자바 9



# 인터페이스

- 특징
  - 추상메서드의 모음 - **public abstract** 의 속성을 갖음
  - 상수 속성만 갖을 수 있음 - **public static final**
  - 다중상속을 지원하지 않는 **extends** 와 달리, **다중 참조가 가능**
- 역할
  - 개발자 사이의 코드 규약을 정한다.
  - 여러 구현체에서 공통적인 부분을 추상화한다.(다형성)



#### 인터페이스 정의하는 방법

interface 예약어를 사용하여 정의

```java
public interface PoliceDog {
    String TYPE = "Police Dog";
    void Tracking();
    void Detection();
}
```

- 메서드는 public abstract 생략됨
- 변수는 public static final 생략됨



#### 인터페이스 구현하는 방법

- implements 예약어 사용, 인터페이스에 정의된 메소드를 Override 함

```java
public class 클래스명 implements 인터페이스명 {
		// 참조한 인터페이스의 메소드 Override
}
```



```java
public class ExplosiveSniffingDog extends Dog implements PoliceDog {

    @Override
    public void Tracking() {
        System.out.println("용의자를 추적합니다.");
    }

    @Override
    public void Detection() {
        System.out.println("마약을 탐지 합니다.");
    }
}
```



- 익명클래스

```java
PoliceDog explosiveSniffingDog = new PoliceDog() {
    @Override
    public void Tracking() {
        System.out.println("훈련이 더 필요 합니다.");
    }

    @Override
    public void Detection() {
        System.out.println("마약을 탐지 합니다.");
    }
}
```





#### 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

- 인터페이스를 구현하면, 해당 인터페이스에 대한 타입의 형변환이 가능함
- 다중의 인터페이스를 구현하면, 다양한 타입이 가능해짐 (다형성)

```java
    interface Scissors {
        void cutPaper();
    }
    interface Knife {
        void cutSomething();
    }
    interface Driver {
        void screw();
        void unscrew();
    }
    interface Pliers {
        void cutWire();
    }
    interface Opener {
        void openBottle();
    }

    public static class MacGyverKnife implements Scissors, Knife, Driver, Pliers, Opener {
        String name = MacGyverKnife.class.getSimpleName();

        @Override
        public void cutPaper() {
            System.out.println("[" + name + "] 종이를 자르다");
        }

        @Override
        public void cutSomething() {
            System.out.println("[" + name + "] 칼로 베다");
        }

        @Override
        public void screw() {
            System.out.println("[" + name + "] 나사를 조이다");
        }

        @Override
        public void unscrew() {
            System.out.println("[" + name + "] 나사를 풀다");
        }

        @Override
        public void cutWire() {
            System.out.println("[" + name + "] 철사를 자르다");
        }

        @Override
        public void openBottle() {
            System.out.println("[" + name + "] 병을 따다");
        }
    }

    public static void main(String[] args) {
        MacGyverKnife macGyverKnife = new MacGyverKnife();
        Scissors scissors = macGyverKnife;
        scissors.cutPaper();
        Knife knife = macGyverKnife;
        knife.cutSomething();
        Driver driver = macGyverKnife;
        driver.screw();
        driver.unscrew();
        Pliers pliers = macGyverKnife;
        pliers.cutWire();
        Opener opener = macGyverKnife;
        opener.openBottle();
    }
```

```shell
[MacGyverKnife] 종이를 자르다
[MacGyverKnife] 칼로 베다
[MacGyverKnife] 나사를 조이다
[MacGyverKnife] 나사를 풀다
[MacGyverKnife] 철사를 자르다
[MacGyverKnife] 병을 따다
```





#### 인터페이스 상속

- 클래스는 다중의 상속을 제공하지 않지만, 인터페이스는 다중 상속이 가능 (단, 인터페이스는 인터페이스만 상속받을 수 있음)

```java
interface RemoteControl {
  	void powerOn();
  	void powerOff();
}

interface TvControl {
  	void changeChannel();
}

interface AudioControl {
  	void volumeUp();
  	void volumeDown();
  	void mute(boolean isOn);
}

interface SmartTvRemoteControl extends RemoteControl, TvControl, AudioControl {
  	boolean memoryChannel(int ch);
  	boolean deleteChannel(int ch);
}
```





#### 인터페이스의 기본 메소드 (Default Method), 자바 8

- 인터페이스에 메소드 선언이 아닌 구현체를 제공하는 방법

- 주의사항
  - 해당 인터페이스를 구현한 클래스를 깨트리지 않고 새 기능을 추가할 수 있다.
  - 기본 메소드는 구현체가 모르게 추가된 기능으로 그만큼 리스크가 있다.
    - 컴파일 에러는 아니지만 구현체에 따라 런타임 에러가 발생할 수 있다.
    - 반드시 문서화 할것. (**@implSpec** 자바독 태그 사용)
  - **Object 가 제공하는 기능** (equals, hasCode)는 기본 메소드로 **제공할 수 없다**.
    - 구현체가 재정의해야 한다.
  - 본인이 수정할 수 있는 인터페이스에만 기본 메소드를 제공할 수 있다.
  - 인터페이스 구현체가 재정의 할 수도 있다.
  - 인터페이스를 **상속받는 인터페이스에서 다시 추상 메소드로 변경** 가능.





####다중상속 문제(Diamond Problem)

- 문제 상황

  > - default 메소드가 있는 인터페이스 Foo
  > - Foo 와 동일한 이름의 default 메소드가 있는 Bar
  > - 어떤 클래스가 인터페이스 Foo, Bar 를 모두 구현하는 경우, 두 인터페이스에 정의된 default 메소드 중 어느 메소드를 참조할 지 알수 없음에 컴파일 오류 발생

- 해결 방법

  > 해당 default 메소드를 구현하는 클래스에서 override 해야 함

- Java 8 의 Solution

  1. **클래스에서 override 한 default method** 가 있다면, 우선 선택

  2. 다중 참조된 interface 가 상속 관계라면, **sub interface 의 default method** 가 선택

  3. 다중 참조된 interface 중 특정 interface 의 default methode 선택시, {타입}.super 를 사용할 수 있음

     > **{타입}.super.**{method}





#### 인터페이스의 static 메소드, 자바 8

- 클래스의 static 과 같이, 인터페이스에 대한 클래스 메소드 지원

- 해당 타입 관련 헬터 또는 유틸리티 메소드를 제공할 때 인터페이스에 static method 를 제공할 수 있음





#### 함수형 인터페이스 (FunctionalInterface)

- 인터페이스 안에 **추상 메소드가 1개 만 존재**하는 경우

순수함수(Pure function)

- 동일한 입력 값이 있는 경우 출력 값은 **항상 동일**한 값이어야 함

Java 에서 기본 제공하는 함수형 인터페이스

- **Function**<T,R>
  - 인자 T, 리턴 R
    - R apply(T t)
  - 함수 조합용 메소드
    - compose(Function f)
      : this.apply(f.apply(t))
    - andThen(Function after)
      : after.apply(this.apply(t))
- **BiFunction**<T,U,R>
  - 인자 T,U, 리턴 R
    - R apply(T t, U u)
  - 함수 조합용 메소드
    - andThen(Function after)
      : after.apply(this.apply(t, u))
- **Consumer**\<T>
  - 인자 T, 리턴 없음 (void)
    - void accept(T t)
  - 함수 조합용 메소드
    - andThen(Consumer after)
      :this.accept(t); after.accept(t)
- **Supplier**\<T>
  - 인자 없음, 리턴 T
    - T get()
- **Predicate**\<T>
  - 인자 T, 리턴 boolean (ture/false)
    - boolean test(T t)
  - 함수 조합용 메소드
    - and
    - or
    - negate
- **UnaryOperator**\<T>
  : Function<T,T>
- **BinaryOperator**\<T>
  : BiFunction<T,T,T>





#### 인터페이스의 private 메소드, 자바 9

- Java 8 에서 default 메소드가 제공되므로, 내부 로직 분리를 제공하기 위해 추가 됨
- private 이므로, abstract 속성이 아님. 상속 불가.
- static 메소드도 private 처리 가능





> 참고
>
> Java in a Nutshell, 7th Edition
>
> https://velog.io/@codemcd/%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4Interface
>
> https://www.inflearn.com/course/the-java-java8
