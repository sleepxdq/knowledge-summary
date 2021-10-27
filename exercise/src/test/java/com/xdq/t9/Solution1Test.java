package com.xdq.t9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author xdq
 */
class Solution1Test {
    private Solution1 solution1 = new Solution1();

    @Test
    void test1() {
        int result = solution1.maxLength(new int[]{});
        assertEquals(0, result);
    }

    @Test
    void test2() {
        int result = solution1.maxLength(new int[]{1, 2, 3});
        assertEquals(3, result);
    }

    @Test
    void test3() {
        int result = solution1.maxLength(new int[]{2, 2, 2});
        assertEquals(1, result);
    }

    @Test
    void test4() {
        int result = solution1.maxLength(new int[]{2, 2, 2, 1, 2, 3});
        assertEquals(3, result);
    }

    @Test
    void test5() {
        int result = solution1.maxLength(new int[]{1, 2, 3, 1, 2, 3});
        assertEquals(3, result);
    }

    @Test
    void test6() {
        int result = solution1.maxLength(new int[]{1, 3, 1, 2, 4, 5});
        assertEquals(5, result);
    }

}