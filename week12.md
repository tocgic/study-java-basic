# 12주차 과제: 애노테이션

> # 목표
>
> 자바의 애노테이션에 대해 학습하세요.
>
> # 학습할 것 (필수)
>
> - 애노테이션 정의하는 방법
> - [@retention](https://github.com/retention)
> - [@target](https://github.com/target)
> - [@documented](https://github.com/documented)
> - 애노테이션 프로세서



# Annotation

- 기본적 의미 : 주석
  : 어노테이션의 용도는 다양한 목적이 있지만 **메타 데이터**의 비중이 가장 큼

  > 메타-테이터(Meta-Data)
  >  : 데이터를 위한 데이터를 의미하며, 풀어 이야기하면 한 데이터에 대한 설명을 의미하는 데이터. (자신의 정보를 담고 있는 데이터)

- Java5 부터 포함됨

- 특징

  - 모두 (암시 적으로) java.lang.annotation.Annotation을 확장
  - 일반적이지 않을 수 있습니다
  - 다른 인터페이스를 확장 할 수 없음
  - 인수가없는 메서드 만 정의 할 수 있음
  - 예외를 발생시키는 메서드를 정의 할 수 없음
  - 메서드의 반환 유형에 제한이 있음
  - 메서드에 대한 기본 반환 값을 가질 수 있음



#### 애노테이션 정의하는 방법

---

@interface 키워드를 사용하면 개발자가 클래스 또는 인터페이스가 사용되는 것과 거의 같은 방식으로 새 주석 유형을 정의 할 수 있음

> 사용자 지정 애노테이션 작성의 핵심은 "메타 주석(meta-annotations)"을 사용하는 것
>
> 새로운 (사용자 정의) 애노테이션 유형의 정의에 나타나는 특수 애노테이션

- 메타 애노테이션 (meta-annotaions)
  : java.lang.annotation에 정의되어 있으며 개발자는 새 애노테이션 유형이 사용되는 위치와 컴파일러 및 런타임에서 처리하는 방법에 대한 정책을 지정할 수 있음

새 애노테이션 유형을 만들 때 필수적으로 필요한 두 가지 기본 메타 애노테이션 (@Target 및 @Retention)이 있음


개발자가 메서드의 닉네임을 정의 할 수있는 @Nickname이라는 간단한 주석의 예

> 이 주석은 런타임에 반영 적으로 메서드를 찾는 데 사용할 수 있음

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Nickname {
    String[] value() default {};
}
```

애노테이션을 정의하는 데 필요한 것은 주석이 나타날 수있는 구문, 보존 정책(RetentionPolicy), 요소 이름입니다.
메서드에 할당 할 닉네임을 제공 할 수 있어야하므로 주석에도 메서드를 정의해야함



#### @Retention

---

javac 및 Java 런타임이 사용자 정의 주석 유형을 처리하는 방법을 나타냄 (어노테이션이 유지되는 범위)

> 어노테이션 유형이있는 어노테이션이 보존되는 기간을 나타냅니다. 어노테이션 유형 선언에 Retention 어노테이션이없는 경우 보존 정책의 기본값은 RetentionPolicy.CLASS입니다.
> 보존 메타 주석은 메타 주석 유형이 주석에 직접 사용되는 경우에만 효과가 있습니다. 메타 주석 유형이 다른 주석 유형의 멤버 유형으로 사용되는 경우에는 효과가 없습니다.
>
> Since: 1.5
> Author: Joshua Bloch

```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Retention {
    /**
     * Returns the retention policy.
     * @return the retention policy
     */
    RetentionPolicy value();
}
```



열거 형 RetentionPolicy로 표시되는 세 가지 값 중 하나를 가질 수 있음

- SOURCE
  이 정책이있는 주석은 컴파일 중에 javac에 의해 삭제됩니다.

  > 일반주석 처럼 사용

- CLASS
  이는 주석이 클래스 파일에 존재하지만 JVM에서 런타임시 반드시 액세스 할 수 없음을 의미합니다. 이것은 거의 사용되지 않지만 JVM 바이트 코드의 오프라인 분석을 수행하는 도구에서 가끔 나타납니다.

- RUNTIME
  이는 사용자 코드가 런타임에 액세스 할 수 있도록 주석을 사용할 수 있음을 나타냅니다 (리플렉션 사용).

```java
public enum RetentionPolicy {
    /**
     * Annotations are to be discarded by the compiler.
     */
    SOURCE,

    /**
     * Annotations are to be recorded in the class file by the compiler
     * but need not be retained by the VM at run time.  This is the default
     * behavior.
     */
    CLASS,

    /**
     * Annotations are to be recorded in the class file by the compiler and
     * retained by the VM at run time, so they may be read reflectively.
     *
     * @see java.lang.reflect.AnnotatedElement
     */
    RUNTIME
}
```



#### @Target

---

새 사용자 지정 주석이 Java 소스 코드 내에 합법적으로 배치 될 수있는 위치를 나타냄

> 주석 유형을 적용 할 수있는 컨텍스트를 나타냅니다. 주석 유형을 적용 할 수있는 선언 컨텍스트 및 유형 컨텍스트는 JLS 9.6.4.1에 지정되어 있으며 java.lang.annotation.ElementType의 열거 형 상수로 소스 코드에 표시됩니다.
> @Target 메타 주석이 주석 유형 T에없는 경우 유형 T의 주석은 유형 매개 변수 선언을 제외한 모든 선언에 대한 수정 자로 작성 될 수 있습니다.
> @Target 메타 주석이있는 경우 컴파일러는 JLS 9.7.4에 따라 ElementType 열거 형 상수로 표시된 사용 제한을 적용합니다.
>
>
> 예를 들어,이 @Target 메타 주석은 선언 된 유형 자체가 메타 주석 유형임을 나타냅니다. 주석 유형 선언에서만 사용할 수 있습니다.
>
> ```java
> @Target(ElementType.ANNOTATION_TYPE)
> public @interface MetaAnnotationType {
>     ...
> }
> ```
>
>
> 이 @Target 메타 주석은 선언 된 유형이 복잡한 주석 유형 선언에서 멤버 유형으로 만 사용하기위한 것임을 나타냅니다. 직접 주석을다는 데는 사용할 수 없습니다.
>
> ```java
> @Target({})
> public @interface MemberType {
>     ...
> }
> ```
>
>
> 단일 ElementType 상수가 @Target 주석에 두 번 이상 나타나는 것은 컴파일 타임 오류입니다. 예를 들어 다음 @Target 메타 주석은 불법입니다.
>
> ```java
> @Target({ElementType.FIELD, ElementType.METHOD, ElementType.FIELD})
> public @interface Bogus {
>     ...
> }
> ```
>
>
> Since: 1.5

```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
    /**
     * Returns an array of the kinds of elements an annotation type
     * can be applied to.
     * @return an array of the kinds of elements an annotation type
     * can be applied to
     */
    ElementType[] value();
}
```



열거 형 ElementType에는 가능한 값 TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTA TION_TYPE, PACKAGE, TYPE_PARAMETER 및 TYPE_USE가 있으며 주석은 이러한 위치 중 하나 이상에서 사용할 의도를 나타낼 수 있습니다.

```java
public enum ElementType {
    /** Class, interface (including annotation type), or enum declaration */
    TYPE,

    /** Field declaration (includes enum constants) */
    FIELD,

    /** Method declaration */
    METHOD,

    /** Formal parameter declaration */
    PARAMETER,

    /** Constructor declaration */
    CONSTRUCTOR,

    /** Local variable declaration */
    LOCAL_VARIABLE,

    /** Annotation type declaration */
    ANNOTATION_TYPE,

    /** Package declaration */
    PACKAGE,

    /**
     * Type parameter declaration
     *
     * @since 1.8
     */
    TYPE_PARAMETER,

    /**
     * Use of a type
     *
     * @since 1.8
     */
    TYPE_USE,

    /**
     * Module declaration.
     *
     * @since 9
     */
    MODULE
}
```



#### @Documented

---

> 주석 @Documented가 주석 유형 A의 선언에있는 경우 요소의 모든 @A 주석은 요소의 공개 계약의 일부로 간주됩니다. 좀 더 자세히 설명하자면, 어노테이션 유형 A가 Documented로 어노테이션 될 때 유형 A 어노테이션의 존재 및 값은 A 어노테이션 요소의 공개 계약의 일부입니다. 반대로, 어노테이션 유형 B가 문서화로 어노테이션되지 않은 경우 B 어노테이션의 존재 및 값은 요소 B 어노테이션의 공개 계약의 일부가 아닙니다. 구체적으로, 주석 유형이 Documented로 주석 처리 된 경우 기본적으로 javadoc과 같은 도구는 출력에 해당 유형의 주석을 표시하지만 Documented가없는 주석 유형의 주석은 표시되지 않습니다.
>
> Since: 1.5
> Author: Joshua Bloch

```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Documented {
}
```



#### @Inherited

---

> 주석 유형이 자동으로 상속됨을 나타냅니다. 상속 된 메타 주석이 주석 유형 선언에 있고 사용자가 클래스 선언에 대한 주석 유형을 쿼리하고 클래스 선언에이 유형에 대한 주석이없는 경우 클래스의 수퍼 클래스가 주석 유형에 대해 자동으로 쿼리됩니다. 이 프로세스는이 유형에 대한 주석을 찾거나 클래스 계층 (Object)의 최상위에 도달 할 때까지 반복됩니다. 이 유형에 대한 주석이있는 수퍼 클래스가없는 경우 쿼리는 해당 클래스에 해당 주석이 없음을 나타냅니다.
> 이 메타 어노테이션 유형은 어노테이션이있는 유형이 클래스가 아닌 다른 것을 어노테이션하는 데 사용되는 경우 효과가 없습니다. 또한이 메타 주석은 주석이 수퍼 클래스에서 상속되도록합니다. 구현 된 인터페이스에 대한 주석은 효과가 없습니다.
>
> Since: 1.5
> Author: Joshua Bloch

```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Inherited {
}
```



#### @Native

---

> 상수 값을 정의하는 필드가 네이티브 코드에서 참조 될 수 있음을 나타냅니다. 주석은 기본 헤더 파일을 생성하는 도구에서 헤더 파일이 필요한지 여부와 필요한 경우 포함해야하는 선언을 결정하는 힌트로 사용할 수 있습니다.
>
> Since: 1.8

```java
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface Native {
}
```



#### @Repeatable

---

>주석 유형 java.lang.annotation.Repeatable은 선언 (meta-) 주석이있는 주석 유형이 반복 가능함을 표시하는 데 사용됩니다. @Repeatable의 값은 반복 가능한 주석 유형에 대한 포함 주석 유형을 나타냅니다.
>
>Since: 1.8

```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Repeatable {
    /**
     * Indicates the <em>containing annotation type</em> for the
     * repeatable annotation type.
     * @return the containing annotation type
     */
    Class<? extends Annotation> value();
}
```



#### 애노테이션 프로세서

---

- 자바 컴파일러 플러그인의 일종

- 애노테이션을 프로세싱하는 기술

- 컴파일 단계에서 어노테이션을 분석하고 처리하기 위해 자바 컴파일러에 동봉된 hook

  > hoook
  >
  > - 이미 작성된 코드의 특정 지점을 가로채서 동작 방식을 변화시킨다.
  >
  > - 대상 코드의 소스를 수정하지 않고 원하는 동작을 구현해야 한다.

- Hook에 부합하는 어노테이션 프로세서

  - 자바 코드(.file)를 만들 수 있다. 따라서 메소드 추가를 위해 인스턴스 생성을 위한 기존 자바 클래스를 조작할 필요가 없다. 마치 직접 코딩한 자바 소스 파일처럼, 자바 컴파일러에 의해 컴파일될 것이다



> 참고
>
> https://elfinlas.github.io/2017/12/14/java-annotation/
> Java in a Nutshell, 7th Edition
