package com.xdq.t7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author xdq
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test0() {
        int result = solution.jumpFloor(0);
        assertEquals(1, result);
    }

    @Test
    void test1() {
        int result = solution.jumpFloor(1);
        assertEquals(1, result);
    }

    @Test
    void test2() {
        int result = solution.jumpFloor(2);
        assertEquals(2, result);
    }

    @Test
    void test7() {
        int result = solution.jumpFloor(7);
        assertEquals(21, result);
    }
}