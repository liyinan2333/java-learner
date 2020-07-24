package leoli.pattern.proxy.demo;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void proxyTest() {
//        new Proxy().request();
        System.out.println("-------------------------------------");
        new Proxy(new RealSubject()).request();
    }

}