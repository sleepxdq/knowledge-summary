package com.xdq.t8;

import java.util.Stack;

/**
 * 链表中倒数最后k个结点
 * <p>
 * 描述
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，输出一个链表，该输出链表包含原链表中从倒数第 k 个结点至尾节点的全部节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 * <p>
 * <p>
 * 数据范围：
 * 0<n≤10^5
 * 0<ai≤10^9
 * 0≤k≤10^9
 * <p>
 * 要求：空间复杂度 O(n)，时间复杂度 O(n)
 * 进阶：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * @author xdq
 */
public class Solution {
    /**
     * 使用栈
     *
     * @param pHead 原始链表
     * @param k     节点的长度为k
     * @return 长度为k的节点或者null
     */
    public ListNode findKthToTail(ListNode pHead, int k) {
        Stack<ListNode> nodes = new Stack<>();
        while (pHead != null) {
            nodes.push(pHead);
            pHead = pHead.next;
        }
        if (nodes.size()<k){
            return null;
        }
        ListNode result = null;
        for (int i = 0; i < k; i++) {
            result = nodes.pop();
        }
        return result;
    }
}
