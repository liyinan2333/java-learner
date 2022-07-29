package liyinan.job.jdk.sleep;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SleepDemo {

    public static void main(String[] args) {

    new Thread(() -> {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "任务执行 -- " + new Date());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }).start();

    }

}
