package com.xdq.t11;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * P1 生产者，生产1-N数字，每生产一个数字，通知消费者来消费
 * C1 消费者， 每消费完一个数字，通知生产者继续生产数字
 * //首先考虑解耦->共享资源
 * //考虑多线程
 */
class Main {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue();
        Object lock = new Object();

        Set<String> names = new HashSet<>();
        names.add("xdq");
        Set<String> ages = new TreeSet<>();
        ages.add("12");
        Set<String> d2= new LinkedHashSet<>();
        d2.add("aa");

        new Thread(new Producer(q, lock)).start();
        new Thread(new Consumer(q, lock, "C1")).start();
        new Thread(new Consumer(q, lock, "C2")).start();
    }

    static class Producer extends Thread {
        private BlockingQueue queue;
        private Object lock;

        public Producer(BlockingQueue q, Object lock) {
            this.queue = q;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                synchronized (this.lock) {
                    send();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int i = 0;

        private void send() throws InterruptedException {
            while (i < 1000) {
                if (this.queue.isEmpty()) {
                    i++;
                    System.out.println("生产者创建数据:" + i);
                    this.queue.put(i);
                } else {
                    //等待消费
                    lock.wait();
                }
                //通知其他线程去消费
                lock.notifyAll();
            }

        }

    }

    static class Consumer extends Thread {
        private BlockingQueue queue;
        private Object lock;
        private String name;

        Consumer(BlockingQueue q, Object lock, String name) {
            this.queue = q;
            this.lock = lock;
            this.name = name;
        }

        private void consume() throws InterruptedException {
            while (true) {
                if (this.queue.isEmpty()) {
                    lock.wait();
                } else {
                    int poll = (int) this.queue.poll();
                    System.out.println("消费者" + name + "消费数据:" + poll);
                }
                lock.notifyAll();
            }
        }

        @Override
        public void run() {
            try {
                synchronized (this.lock) {
                    consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}