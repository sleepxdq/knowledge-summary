package com.xdq.t6;

import java.util.ArrayList;

/**
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 *
 * @author xdq
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> orders = new ArrayList<>();

    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            countOrder(root, 0);
        }
        return orders;
    }

    private void countOrder(TreeNode node, int level) {
        if (orders.size() == level) {
            orders.add(new ArrayList<>());
        }
        if (node != null) {
            ArrayList<Integer> order = orders.get(level);
            order.add(node.val);
        }
        if (node.left != null) {
            countOrder(node.left, level + 1);
        }
        if (node.right != null) {
            countOrder(node.right, level + 1);
        }
    }
}
