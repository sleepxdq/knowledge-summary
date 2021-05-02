package com.xdq.observer;

/**
 * @author Seven.Xu
 * @version 2021/4/30
 **/
@FunctionalInterface
public interface Task<R> {

    /**
     * 任务执行接口
     * @return
     */
    R call() throws InterruptedException;
}
