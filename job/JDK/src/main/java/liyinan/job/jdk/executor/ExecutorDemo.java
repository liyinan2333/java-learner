package liyinan.job.jdk.executor;

import java.util.Date;
import java.util.concurrent.*;

public class ExecutorDemo {

    public static void main(String[] args) {
        // 1. 获取周期性线程池, 传入核心线程的大小
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始执行任务 -- " + new Date());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "任务执行完毕 -- " + new Date());
        };

        // 线程0秒后开始执行，每三秒执行一次。
        scheduledExecutorService.scheduleAtFixedRate(r, 0, 3, TimeUnit.SECONDS);
    }

}
