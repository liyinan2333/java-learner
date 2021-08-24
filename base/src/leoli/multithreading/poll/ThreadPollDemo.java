package leoli.multithreading.poll;

import java.util.concurrent.Executors;

/**
 * 常用的线程池
 *
 * @author leoli
 * @date 2020/2/23
 */
public class ThreadPollDemo {

    public static void main(String[] args) {

        // 带Scheduled的，可定时触发
        Executors.newScheduledThreadPool(3);
        Executors.newSingleThreadScheduledExecutor();

        // 单线程的
        Executors.newSingleThreadExecutor();
        // 固定线程数的
        Executors.newFixedThreadPool(3);
        // 自动增长的
        Executors.newCachedThreadPool();
        // 具有抢占式操作的
        Executors.newWorkStealingPool();

    }

}
