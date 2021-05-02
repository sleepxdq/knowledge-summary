package com.xdq.observer;

/**
 * @author Seven.Xu
 * @version 2021/4/30
 **/
public class EmptyLifecycle<T> implements TaskLifecycle<T> {
    @Override
    public void onStart(Thread thread) {

    }

    @Override
    public void onRunning(Thread thread) {

    }

    @Override
    public void onFinish(Thread thread, T result) {

    }

    @Override
    public void onError(Thread thread, Exception e) {

    }
}
