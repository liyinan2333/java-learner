package leoli.jdk.lamda;

import leoli.jdk.lamda.bean.User;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大函数式编程接口演示
 *
 * @author leoli
 * @date 2020/8/11
 */
public class FunctionalInterfaceDemo {

    /**
     * 打印user信息
     */
    public void print(User user, Consumer<User> userConsumer) {
        userConsumer.accept(user);
    }

    /**
     * 返回一个user
     */
    public User getUser(Supplier<User> userSupplier) {
        return userSupplier.get();
    }

    /**
     * 转换一个user
     */
    public User transformUser(User user, Function<User, User> function) {
        return function.apply(user);
    }

    /**
     * 检验User是否合法
     */
    public boolean checkUser(User user, Predicate<User> predicate) {
        return predicate.test(user);
    }

    public static void main(String[] args) {

        User userObj = new User();
        userObj.setName("西门吹雪");
        userObj.setAge(22);

        // 测试Consumer
        FunctionalInterfaceDemo mainInst = new FunctionalInterfaceDemo();
        mainInst.print(userObj, user -> System.out.println(user));

        // 测试Supplier
        final User user1 = mainInst.getUser(() -> {
            User user = new User();
            user.setName("叶孤城");
            user.setAge(22);
            return user;
        });
        System.out.println(user1);

        // 将西门吹雪的年龄改为25
        final User user2 = mainInst.transformUser(userObj, (user -> {
            user.setAge(25);
            return user;
        }));
        System.out.println(user2);

        // 判断User是否是西门吹雪
        final boolean checkUser = mainInst.checkUser(userObj, (user -> user.getName().equals("西门吹雪")));
        System.out.println(checkUser);
    }

}
