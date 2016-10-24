package com.maqianyu.nicedrama.Tools;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dllo on 16/10/24.
 * 线程池的单例类
 */
public class ThreadPoolInstance {
    private ThreadPoolExecutor executor;
    private static ThreadPoolInstance instance;

    private ThreadPoolInstance() {
        // cup个数
        int count = Runtime.getRuntime().availableProcessors();
        // 核心线程个数
        int coreCount = count + 1;
        // 最大任务线程数
        int maxSize = count * 2 + 1;
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(count + 1);
        executor = new ThreadPoolExecutor(coreCount, maxSize, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return null;
                    }
                });
        executor.allowCoreThreadTimeOut(true);
    }

    public static ThreadPoolInstance getInstance(){
        if (instance == null) {
            synchronized (ThreadPoolInstance.class){
                if (instance == null){
                    instance = new ThreadPoolInstance();
                }
            }
        }
        return instance;
    }

    /**
     * 开始一个线程
     * @param r
     */
    public void startThread(Runnable r) {
        executor.execute(r);
    }

    /**
     * 停止一个线程
     */
    public void stopThread() {
        executor.shutdown();
    }

    /**
     * 线程是否停止
     */
    public boolean isThreadStop() {
        return executor.isShutdown();
    }

    /**
     * 销毁一个线程
     */
    public void removeThread(Runnable r) {
        executor.remove(r);
    }
}
