package leoli.hotswap.plugin.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PluginAspect {

    // @Before(value = ("execution(* com.zzh.controller.*.*(..))"))
    @Before(value = ("@annotation(org.springframework.web.bind.annotation.RequestMapping)"))
    public void oo() {
    }

}
