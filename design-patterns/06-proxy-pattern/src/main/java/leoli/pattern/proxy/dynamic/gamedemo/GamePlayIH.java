package leoli.pattern.proxy.dynamic.gamedemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 被代理者
public class GamePlayIH implements InvocationHandler {
    // 被代理的实例
    Class clazz = null;
    // 我要代理谁
    Object obj = null;

    public GamePlayIH(Object _obj) {
        this.obj = _obj;
    }

    // 调用被代理的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        // 如果是登录方法，则发送信息(AOP)
        if(method.getName().equals("login")) {
            System.out.println("有人在用账号" + args[0] + "登录");
        }
        return method.invoke(this.obj, args);
    }
}
