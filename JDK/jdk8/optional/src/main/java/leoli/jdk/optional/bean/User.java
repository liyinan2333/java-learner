package leoli.jdk.optional.bean;

import lombok.Data;

import java.util.Optional;

/**
 * @author leoli
 * @date 2020/8/1
 */
@Data
public class User {
    private String name;
    private Integer age;
    private Optional<Address> address = Optional.empty();
}