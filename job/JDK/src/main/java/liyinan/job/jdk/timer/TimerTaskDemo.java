package liyinan.job.jdk.timer;

import java.util.Date;
import java.util.Timer;

/**
 * @author liyinan2333
 * @date 2022/7/27
 * <p>
 * Timer 也会有一些缺陷：
 * <p>
 * Timer 是单线程的，假如有任务 A,B,C，任务 A 如果执行时间比较长，那么就会影响任务 B,C 的启动和执行时间，如果 B,C 执行时间也比较长，那就会相互影响；
 * Timer 不会捕获异常，如果 A,B,C 任何一个任务在执行过程中发生异常，就会导致 TImer 整个定时任务停止工作；
 * Timer 是基于绝对时间调度的，而不是基于相对时间，所以它对系统时间的改变非常敏感；
 * 所以，如果在使用 Timer 的过程中要注意这些缺陷，虽然可以用，但不推荐。
 */
public class TimerTaskDemo {

    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();
        java.util.TimerTask timerTask = new java.util.TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "任务执行 -- " + new Date());
            }
        };

        // 第一次任务延迟时间
        long delay = 2 * 1000;
        // 任务执行频率
        long period = 3 * 1000;
        // 开始调度
        timer.schedule(timerTask, delay, period);

        // 指定首次运行时间
//        timer.schedule(timerTask, DateUtils.addSeconds(new Date(), 5), period);

        Thread.sleep(10 * 1000);

        // 终止并移除任务
        timer.cancel();
        timer.purge();
    }

}
