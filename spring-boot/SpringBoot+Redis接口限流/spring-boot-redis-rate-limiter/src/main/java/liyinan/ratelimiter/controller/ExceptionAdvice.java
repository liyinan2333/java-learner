package liyinan.ratelimiter.controller;

import liyinan.ratelimiter.exception.LimitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Controller异常处理
 *
 * @author liyinan2333
 * @date 2022/06/17
 */
@RestControllerAdvice(basePackageClasses = Controller.class)
public class ExceptionAdvice {

    private static Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * 只要发生限流，就会调用这个方法
     *
     * @param e        aop抛出的限流异常
     * @param request  利用request和response方便对异常的后后续处理
     * @param response
     * @throws IOException
     */
    @ExceptionHandler({LimitException.class})//LimitException.classs的作用是代表异常的类型，这里Exception就代表全部的类型
    public void handlerException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("限流触发 -->" + request);
        //得到请求方式
        String xRequestedWith = request.getHeader("x-requested-with");
        //如果是异步请求，则返回统一处理数据给前端
        response.setContentType("application/plain;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(e.getMessage());
    }

}
