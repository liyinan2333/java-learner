package leoli.multithreading.use;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个死锁的演示
 *
 * 死锁的排查方法：
 * 1. jps查看pid
 * 2. jstack {pid} 打印进程堆栈信息
 * eg:
 *    Found one Java-level deadlock:
 * =============================
 * "Thread-0":
 *   waiting for ownable synchronizer 0x00000000c7c7e180, (a java.util.concurrent.locks.ReentrantLock$NonfairSync),
 *   which is held by "Thread-1"
 * "Thread-1":
 *   waiting for ownable synchronizer 0x00000000c7c7e150, (a java.util.concurrent.locks.ReentrantLock$NonfairSync),
 *   which is held by "Thread-0"
 *
 * Java stack information for the threads listed above:
 * ===================================================
 * "Thread-0":
 *         at jdk.internal.misc.Unsafe.park(java.base@11.0.10/Native Method)
 *         - parking to wait for  <0x00000000c7c7e180> (a java.util.concurrent.locks.ReentrantLock$NonfairSync)
 *         at java.util.concurrent.locks.LockSupport.park(java.base@11.0.10/LockSupport.java:194)
 *         at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(java.base@11.0.10/AbstractQueuedSynchronizer.java:885)
 *         at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireQueued(java.base@11.0.10/AbstractQueuedSynchronizer.java:917)
 *         at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquire(java.base@11.0.10/AbstractQueuedSynchronizer.java:1240)
 *         at java.util.concurrent.locks.ReentrantLock.lock(java.base@11.0.10/ReentrantLock.java:267)
 *         at leoli.multithreading.use.DeadLockDemo.lambda$main$0(DeadLockDemo.java:29)
 *         at leoli.multithreading.use.DeadLockDemo$$Lambda$14/0x0000000100066840.run(Unknown Source)
 *         at java.lang.Thread.run(java.base@11.0.10/Thread.java:834)
 * "Thread-1":
 *         at jdk.internal.misc.Unsafe.park(java.base@11.0.10/Native Method)
 *         - parking to wait for  <0x00000000c7c7e150> (a java.util.concurrent.locks.ReentrantLock$NonfairSync)
 *         at java.util.concurrent.locks.LockSupport.park(java.base@11.0.10/LockSupport.java:194)
 *         at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(java.base@11.0.10/AbstractQueuedSynchronizer.java:885)
 *         at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireQueued(java.base@11.0.10/AbstractQueuedSynchronizer.java:917)
 *         at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquire(java.base@11.0.10/AbstractQueuedSynchronizer.java:1240)
 *         at java.util.concurrent.locks.ReentrantLock.lock(java.base@11.0.10/ReentrantLock.java:267)
 *         at leoli.multithreading.use.DeadLockDemo.lambda$main$1(DeadLockDemo.java:36)
 *         at leoli.multithreading.use.DeadLockDemo$$Lambda$15/0x0000000100066c40.run(Unknown Source)
 *         at java.lang.Thread.run(java.base@11.0.10/Thread.java:834)
 *
 * Found 1 deadlock.
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
