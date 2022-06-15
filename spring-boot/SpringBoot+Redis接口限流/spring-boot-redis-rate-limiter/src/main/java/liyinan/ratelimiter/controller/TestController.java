package liyinan.ratelimiter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liyinan2333
 * @date: 2022/06/14
 */
@RestController("test")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("set")
    public ResponseEntity set(@RequestParam String key, @RequestParam String value) {
        Assert.notNull(key, "Key is null");
        Assert.notNull(value, "Value is null");
        redisTemplate.opsForValue().set(key, value);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("get")
    public ResponseEntity get(@RequestParam String key) {
        Assert.notNull(key, "Key is null");
        return ResponseEntity.ok(redisTemplate.opsForValue().get(key));
    }

}
