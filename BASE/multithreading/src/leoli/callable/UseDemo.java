package leoli.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable接口的使用案例
 *
 * @author leoli
 * @date 2020/2/22
 */
public class UseDemo {

    public static void main(String[] args) {

        System.out.println("==>Main start");

        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new MyCallable());

        try {
            // 这里会发生阻塞
            System.out.println("返回值==>" + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        System.out.println("==>Main end");

    }

}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        // 模拟耗时任务
        Thread.sleep(3000);
        System.out.println("MyCallable线程ID：" + Thread.currentThread().getName());
        return "dududu~";
    }
}