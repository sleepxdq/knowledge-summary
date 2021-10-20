package com.xdq.t5;

/**
 * 二分查找
 * 请实现有重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）长度为n的整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的第一个出现的target，如果目标值存在返回下标，否则返回 -1
 * <p>
 * 示例1
 * 输入：[1,2,4,4,5],4
 * 返回值：2
 * 说明：从左到右，查找到第1个为4的，下标为2，返回2
 *
 * @author xdq
 */
public class Solution {

    /**
     * 如果目标值存在返回下标，否则返回 -1
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        int mid = 0;
        int high = nums.length - 1;
        int low = 0;
        while (high >= low) {
            //对于重复的特殊处理
            if (nums[0] == target) {
                return 0;
            }
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                //有可能多个相同的
                while (mid != 0 && nums[mid - 1] == nums[mid]) {
                    mid--;
                }
                return mid;
            } else if (nums[mid] > target) {
                //往前找
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
