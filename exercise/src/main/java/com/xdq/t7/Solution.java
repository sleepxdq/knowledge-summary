package com.xdq.t7;

/**
 * 跳台阶
 *
 * <p>描述</p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * <p>
 * 数据范围：0≤n≤40
 * 要求：时间复杂度：O(n) ，空间复杂度：O(1)
 * <p>
 * 思路：
 * 题目分析，假设f[i]表示在第i个台阶上可能的方法数。逆向思维。如果我从第n个台阶进行下台阶，下一步有2中可能，一种走到第n-1个台阶，一种是走到第n-2个台阶。所以f[n] = f[n-1] + f[n-2].
 * 那么初始条件了，f[0] = f[1] = 1。
 * 所以就变成了：f[n] = f[n-1] + f[n-2], 初始值f[0]=1, f[1]=1，目标求f[n]
 *
 * @author xdq
 */
public class Solution {
    public int jumpFloor(int target) {
        if (target == 0 || target == 1) {
            return 1;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    public static void main(String[] args) {

    }
}
