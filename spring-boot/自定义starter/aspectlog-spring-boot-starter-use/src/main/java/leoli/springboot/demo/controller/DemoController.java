package leoli.springboot.demo.controller;

import leoli.springboot.autoconfiguration.aspectlog.AspectLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @AspectLog
    @GetMapping("hello")
    public String sayHello() {
        return "hello";
    }

}
