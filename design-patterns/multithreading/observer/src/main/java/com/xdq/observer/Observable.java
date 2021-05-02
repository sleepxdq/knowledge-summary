package com.xdq.observer;

/**
 * 需要Thread其他方法可以在这个接口里扩展
 * @author Seven.Xu
 * @version 2021/4/30
 **/
public interface Observable {
    /**
     * 获取当前任务的生命周期
     * @return
     */
    Cycle getCycle();

    /**
     * 定义启动线程的方法，主要作用为了屏蔽Thread的其他方法
     */
    void start();

    /**
     * 定义打断线程的方法，也是为了屏蔽Thread的方法
     */
    void interrupt();

}
