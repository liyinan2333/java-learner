package leoli.zookeeper.demo;

import leoli.zookeeper.config.ZkConfig;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.
                builder().connectString(ZkConfig.IP_LIST).sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)).namespace("").build();
        curatorFramework.start();
        Stat stat = new Stat();
        //查询节点数据
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/leoli");
        System.out.println(new String(bytes));
        curatorFramework.close();
    }

}
