package com.xdq.t4;

import java.util.Stack;

/**
 * 一个存，一个出，出的没有了把存的放到出的里面；
 * 可以想想两个杯子怎么进是最小的出来也是最小的
 * @author xdq
 */
public class Solution2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
