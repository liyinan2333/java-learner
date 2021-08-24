package leoli.multithreading.thread;

/**
 * 多次start一个线程会怎么样？
 *
 * @author leoli
 * @date 2020/2/23
 */
public class ThreadDemo {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ended");
        });
        thread.start();
        thread.start();

    }

}
