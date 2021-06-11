package leoli.hotswap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author leoli
 * @date 2021/06/06
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("list")
    public List<String> list() {
        return Arrays.asList(new String[]{"Leo", "Candy"});
    }

}