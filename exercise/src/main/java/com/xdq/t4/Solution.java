package com.xdq.t4;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 栈：先进后出
 * 队列：先进先出
 *
 * 思路：来回反转
 * @author xdq
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            stack1.push(node);
            return;
        }

        if (stack1.isEmpty()) {
            //反转
            reverse(this.stack1, this.stack2);
            //再压栈
            this.stack2.push(node);
            //再反转
            reverse(this.stack2, this.stack1);
        } else {
            //反转
            reverse(this.stack2, this.stack1);
            //再压栈
            this.stack1.push(node);
            //再反转
            reverse(this.stack1, this.stack2);
        }
    }

    private void reverse(Stack<Integer> target, Stack<Integer> source) {
        while (!source.empty()) {
            target.push(source.pop());
        }
    }

    public int pop() {
        if (stack1.empty()) {
            return stack2.pop();
        } else {
            return stack1.pop();
        }
    }

    public static void main(String[] args) {
        //["PSH1","PSH2","POP","POP"]
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}
