package leoli.zookeeper.demo;

import leoli.zookeeper.config.ZkConfig;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ConnectionDemo {

    public static void main(String[] args) throws InterruptedException, KeeperException, IOException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper =
                // 集群各节点ip端口,","分隔
                new ZooKeeper(ZkConfig.IP_LIST,
                        4000, new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        if (Event.KeeperState.SyncConnected == event.getState()) {
                            //如果收到了服务端的响应事件，连接成功
                            countDownLatch.countDown();
                        }
                    }
                });
        countDownLatch.await();
        //CONNECTED
        System.out.println(zooKeeper.getState());
        // 创建一个节点,数据
        zooKeeper.create("/leoli", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        TimeUnit.MINUTES.sleep(500);
    }

}
