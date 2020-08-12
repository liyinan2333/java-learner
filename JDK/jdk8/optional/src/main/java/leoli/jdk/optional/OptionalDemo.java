package leoli.jdk.optional;

import leoli.jdk.optional.bean.Address;
import leoli.jdk.optional.bean.Street;
import leoli.jdk.optional.bean.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * jdk8 optional 演示
 *
 * @author leoli
 * @date 2020/8/1
 */
public class OptionalDemo {

    public static void main(String[] args) {
        // 例一：
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

        // 示例二：修改示例一，使其生成一个非空值的Optional实例
        Optional<String> firstName = Optional.of("Tom");
        System.out.println("First Name is set? " + firstName.isPresent());
        System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
        System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

        // 示例三：使用Optional避免空指针
        System.out.println(getUserSteetName(new User()));
    }

    public static String getUserSteetName(User user) {
        Optional<User> userOptional = Optional.ofNullable(user);
        final String streetName = userOptional.orElse(new User()).getAddress().orElse(new Address()).getStreet().orElse(new Street()).getStreetName();
        return StringUtils.isEmpty(streetName) ? "nothing found" : streetName;
    }

}
