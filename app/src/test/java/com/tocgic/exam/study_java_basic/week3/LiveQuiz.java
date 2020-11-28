package com.tocgic.exam.study_java_basic.week3;

import org.junit.Test;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

/**
 * 11/28 live
 */
public class LiveQuiz {

    /**
     * 중간 값을 구하시오
     */
    @Test
    public void findMiddleValue() {
        int start = Integer.MAX_VALUE - 1000;
        int end = Integer.MAX_VALUE;

        int mid;
        mid = (start + end) / 2; // overflow
        System.out.println(mid);
        mid = start + (end - start) / 2; // best
        System.out.println(mid);
        mid = (start + end) >>> 1; // 간지
        System.out.println(mid);
    }

    /**
     * 배열에, 한가지 숫자만 제외하고 2개씩 반복되는 수들의 집합 중, 중복되지 않은 값 은?
     */
    @Test
    public void nonDuplicateValues() {
        int[] numbers = {1,2,2,3,3,4,4,5,5,6,6};

        System.out.println(nonDuplicateValues(numbers));
        System.out.println(nonDuplicateValuesXor(numbers));
    }

    /**
     * map 을 이용하여 중복 카운트 확인
     * @param numbers
     * @return
     */
    public int nonDuplicateValues(@Nonnull int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : numbers) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    /**
     * xor 의 특정을 이용
     * 5 ^ 0 = 5
     * 5 ^ 5 = 0
     * xor 연산의 순서는 바뀌어도 값은 동일함.
     * @param numbers
     * @return
     */
    public int nonDuplicateValuesXor(@Nonnull int[] numbers) {
        int value = 0;
        for (int number : numbers) {
            value ^= number;
        }
        return value;
    }

    public void intelliJTip(@Nonnull int[] numbers) {
        //iter
        for (int number : numbers) {

        }

        //itar
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

        }
    }
}
