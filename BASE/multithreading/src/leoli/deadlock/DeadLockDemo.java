package leoli.deadlock;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个死锁的演示
 *
 * @author leoli
 * @date 2021/2/22
 */
public class DeadLockDemo {

    public static void main(String[] args) {

        Executors.newScheduledThreadPool(2);

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        new Thread(() -> {
            lock1.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock2.lock();
                lock1.unlock();
                lock2.unlock();
            }
        }).start();
        new Thread(() -> {
            lock2.lock();
            lock1.lock();
            lock2.unlock();
            lock1.unlock();
        }).start();

    }

}
