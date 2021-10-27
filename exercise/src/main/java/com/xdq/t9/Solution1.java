package com.xdq.t9;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 最长无重复数组
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * <p>
 * 方法1：使用队列
 * 方法2：双指针
 *
 * @author xdq
 */
public class Solution1 {
    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        int maxLength = 0;
        for (int e : arr) {
            while (queue.contains(e)) {
                queue.poll();
            }
            queue.add(e);
            maxLength = Math.max(maxLength, queue.size());
        }
        return maxLength;
    }

}
