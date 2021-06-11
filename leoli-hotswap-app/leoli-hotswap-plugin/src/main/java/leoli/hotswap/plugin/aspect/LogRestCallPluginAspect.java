package leoli.hotswap.plugin.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogRestCallPluginAspect {

    // @Before(value = ("execution(* com.zzh.controller.*.*(..))"))
    // (类上有@Controller或者@RestController) 且 方法或者类上有@RequestMapping
    @Before(value = ("(@within(org.springframework.stereotype.Controller) || @within(org.springframework.web.bind.annotation.RestController)) && (@within(org.springframework.web.bind.annotation.RequestMapping) || @annotation(org.springframework.web.bind.annotation.RequestMapping))"))
    public void oo() {
    }

}
