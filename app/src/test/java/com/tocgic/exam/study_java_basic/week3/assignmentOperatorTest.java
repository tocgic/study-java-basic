package com.tocgic.exam.study_java_basic.week3;

import com.tocgic.exam.study_java_basic.week3.instance_of.RadioPlayer;
import org.junit.Test;

public class assignmentOperatorTest {
    @Test
    public void assignment() {
        String gun = "총";
        String rocket = "로켓탄";
        String dagger = "단검";
        String name = "홍길동";
        Object weapon = dagger;
    }

    @Test
    public void assignment2() {
        int total = 0;
        total += 2;
        total -= 2;
        total *= 2;
        total /= 2;
    }

    @Test
    public void lambdaExpression() {
        RadioPlayer player = new RadioPlayer() {
            @Override
            public void playRadio(float channel) {
                System.out.println("play radio - " + channel);
            }
        };
        player.playRadio(95.9f);

        // new RadioPlayer() 제거
        RadioPlayer player2 = (float channel) -> {
            System.out.println("play radio - " + channel);
        };
        player2.playRadio(95.9f);

        // 인터페이스 내 코드 내용이 한줄로, {} 생략 가능
        RadioPlayer player3 = (float channel) -> System.out.println("play radio - " + channel);
        player3.playRadio(95.9f);

        // 파라미터 타입 생략
        RadioPlayer player4 = channel -> System.out.println("play radio - " + channel);
        player4.playRadio(95.9f);
    }
}
