package com.xdq.t8;

/**
 * @author xdq
 */
public class Solution2 {
    /**
     * 使用快慢指针
     *
     * @param pHead 原始链表
     * @param k     节点的长度为k
     * @return 长度为k的节点或者null
     */
    public ListNode findKthToTail(ListNode pHead, int k) {
        ListNode fastNode = pHead;
        ListNode slowNode = pHead;
        for (int i = 0; i < k; i++) {
            if (fastNode == null) {
                return null;
            }
            fastNode = fastNode.next;
        }
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return fastNode;
    }
}
