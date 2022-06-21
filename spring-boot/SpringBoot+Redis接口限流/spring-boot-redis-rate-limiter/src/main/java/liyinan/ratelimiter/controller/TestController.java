package liyinan.ratelimiter.controller;

import liyinan.ratelimiter.constants.LimitType;
import liyinan.ratelimiter.constants.anno.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: liyinan2333
 * @date: 2022/06/14
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/limit")
    @RateLimiter(time = 5,count = 3,limitType = LimitType.IP)
    public String limit() {
        return ">>>"+new Date();
    }

    @RequestMapping("set")
    public ResponseEntity set(@RequestParam String key, @RequestParam String value) {
        Assert.notNull(key, "Key is null");
        Assert.notNull(value, "Value is null");
        redisTemplate.opsForValue().set(key, value);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("get")
    public ResponseEntity get(@RequestParam String key) {
        return ResponseEntity.ok(redisTemplate.opsForValue().get(key));
    }

}
