package leoli.use;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 假如有Thread1、Thread2、Thread3、Thread4四条线程分别统计C、D、E、F四个盘的大小，
 * 所有线程统计完毕后交给Thread5线程做汇总，如何实现？
 *
 * @author leoli
 * @date 2020/2/23
 */
public class SummaryDemo {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(4);
        new Thread(() -> {
            queue.offer(10);
        }).start();
        new Thread(() -> {
            queue.offer(20);
        }).start();
        new Thread(() -> {
            queue.offer(30);
        }).start();
        new Thread(() -> {
            queue.offer(40);
        }).start();
        for (; ; ) {
            if (queue.size() == 4) {
                int sum = queue.poll() + queue.poll() + queue.poll() + queue.poll();
                System.out.println(sum);
                break;
            }
        }
    }

}
