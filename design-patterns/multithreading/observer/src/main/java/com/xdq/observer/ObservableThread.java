package com.xdq.observer;

import java.util.Objects;

/**
 * @author Seven.Xu
 * @version 2021/4/30
 **/
public class ObservableThread<R> extends Thread implements Observable {

    private final TaskLifecycle<R> lifecycle;
    private final Task<R> task;
    private Cycle cycle;

    /**
     * 指定Task实现，默认执行EmptyLifecycle
     *
     * @param task
     */
    public ObservableThread(Task<R> task) {
        this(new TaskLifecycle.EmptyLifecycle<R>(), task);
    }

    public ObservableThread(TaskLifecycle<R> lifecycle, Task<R> task) {
        super();//初始化Thread
        Objects.requireNonNull(task,"task cannot be null");
        this.lifecycle = lifecycle;
        this.task = task;
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }

    /**
     * final防止重写
     */
    @Override
    public final void run() {
        this.update(Cycle.STARTED, null, null);
        try {
            this.update(Cycle.RUNNING, null, null);
            R result = this.task.call();
            this.update(Cycle.DONE, result, null);
        } catch (Exception e) {
            this.update(Cycle.ERROR, null, e);
        }
    }

    private void update(Cycle cycle, R result, Exception e) {
        this.cycle = cycle;
        if (lifecycle == null) {
            return;
        }
        try {
            switch (this.cycle) {
                case STARTED:
                    this.lifecycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.lifecycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.lifecycle.onFinish(currentThread(), result);
                    break;
                case ERROR:
                    this.lifecycle.onError(currentThread(), e);
            }
        } catch (Exception ex) {
            //不能屏蔽任务执行的异常
            if (cycle == Cycle.ERROR) {
                throw ex;
            }
            //通知后出现异常需要catch，防止影响任务的正常执行
        }

    }
}
