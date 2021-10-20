package com.xdq.t3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xdq
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        //[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],4

        int[][] a = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int[] lru = solution.LRU(a, 4);
        int[] act = {1, 2};
        assertArrayEquals(act,lru);
    }

    @Test
    void test2() {
        //[[1,1,1],[1,2,2],[1,1,3],[2,1],[2,1]],3

        int[][] a = {{1, 1, 1}, {1, 2, 2}, {1, 1, 3}, {2, 1},  {2, 1}};
        int[] lru = solution.LRU(a, 3);
        int[] act = {3, 3};
        assertArrayEquals(act,lru);
    }

}