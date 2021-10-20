package com.xdq.t3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xdq
 */
public class Solution {
    private int size;
    private Node head;
    private Node last;
    private int cap;

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here
        this.cap = k;
        this.size = 0;
        this.head = null;
        this.last = null;
        int[] member = null;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < operators.length; i++) {
            member = operators[i];
            int opt = member[0];
            if (opt == 1) {
                //set
                set(member[1], member[2]);
            } else if (opt == 2) {
                //get
                result.add(get(member[1]));
            } else {
                return null;
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private int get(int key) {
        //如果存在就刷新缓存
        Node current = this.head;
        while (current != null) {
            if (current.key == key) {
                refresh(current);
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    private void refresh(Node node) {
        Stack<Integer> stack = new Stack<>();
        //放到最后一个
        //1.node处在尾
        if (node.next == null) {
            return;
        }
        //2.node处在头，需要放在最后面
        if (this.head.key == node.key) {
            this.head = this.head.next;
            Node current = this.head;
            while (true){
                if (current.next==null){
                    current.next=node;
                    node.next=null;
                    return;
                }
                current = current.next;
            }
        }
        //3.node处在中间
        Node current = this.head;
        Node pre = null;
        while (true) {
            if (current.key == node.key) {
                pre.next = current.next;
            }
            if (current.next==null){
                current.next=node;
                node.next=null;
                return;
            }
            pre = current;
            current = current.next;
        }

    }

    private void set(int key, int value) {
        if (this.head == null) {
            this.size++;
            this.head = new Node(key, value);
            this.last = this.head;
            this.last.next = null;
            return;
        }
        if (this.size >= this.cap) {
            deleteFirst();
        }
        Node current = this.head;
        while (true) {
            //覆盖情况，相同的key
            if (current.key == key) {
                current.value = value;
                refresh(current);
                break;
            }
            if (current.next == null) {
                this.size++;
                current.next = new Node(key, value);
                this.last = current.next;
                break;
            }
            current = current.next;
        }

    }

    private void deleteFirst() {
        this.head = this.head.next;
    }
}
