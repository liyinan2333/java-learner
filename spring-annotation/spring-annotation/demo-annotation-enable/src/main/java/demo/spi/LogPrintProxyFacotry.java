package demo.spi;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author: liyinan2333
 * @date: 2022/06/08
 */
public class LogPrintProxyFacotry {

    private static final LogPrintProxyFacotry INSTANCE = new LogPrintProxyFacotry();
    private static final LogPrintProxy PROXY = new LogPrintProxy();

    private LogPrintProxyFacotry() {
    }

    public static LogPrintProxyFacotry get() {
        return INSTANCE;
    }

    public <T> T createProxy(T source) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(source.getClass());
        enhancer.setCallback(PROXY);
        return (T) enhancer.create();
    }
}
