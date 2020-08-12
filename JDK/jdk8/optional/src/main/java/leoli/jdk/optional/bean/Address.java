package leoli.jdk.optional.bean;

import lombok.Data;

import java.util.Optional;

/**
 * @author leoli
 * @date 2020/8/1
 */
@Data
public class Address {
    private Optional<Street> street = Optional.empty();
}
