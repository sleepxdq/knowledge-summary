package com.xdq.observer;

import java.util.concurrent.TimeUnit;

/**
 * @author Seven.Xu
 * @version 2021/4/30
 **/
public class Main {
    public static void main(String[] args) {
        TaskLifecycle<String> lifecycle = new TaskLifecycle<String>() {
            @Override
            public void onStart(Thread thread) {
                System.out.println("任务start");
            }

            @Override
            public void onRunning(Thread thread) {
                System.out.println("任务running");
            }

            @Override
            public void onFinish(Thread thread, String result) {
                System.out.println("任务finish,result:" + result);
            }

            @Override
            public void onError(Thread thread, Exception e) {
                System.out.println("任务error,exception:" + e);
            }
        };

        Observable observable = new ObservableThread<>(lifecycle, () -> {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("任务内容");
            return "任务结果";
        });
        observable.start();
    }
}
