package org.fireking.meitukong.supports;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangg on 16/1/3.
 */
public class ThreadPool {

    private static volatile ThreadPool instance = null;

    private ExecutorService service;

    private ThreadPool() {
        service = Executors.newFixedThreadPool(5);
    }

    public static ThreadPool getInstance() {
        if (instance == null) {
            synchronized (ThreadPool.class) {
                if (instance == null) {
                    instance = new ThreadPool();
                }
            }
        }
        return instance;
    }

    public void submit(Runnable task) {
        service.submit(task);
    }
}
