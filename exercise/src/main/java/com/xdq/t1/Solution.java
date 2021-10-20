package com.xdq.t1;

/**
 * @author xdq
 */
public class Solution {

    public static ListNode detectCycle(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.getNext();
                    slow = slow.getNext();
                }
                return ptr;
            }
        }
        return null;
    }
}
