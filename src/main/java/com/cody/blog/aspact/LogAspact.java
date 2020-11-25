package com.cody.blog.aspact;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author Cody
 * @date 2020/11/3 - 20:44
 */
@Aspect
@Component
public class LogAspact {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.cody.blog.controller.*.*(..))")
    public void log(){}
    /**
     * 切面之前执行
     */
    @Before("log()")
    public void  doBefore(JoinPoint joinPoint){
        /**
         * 获取request
         */
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String classMeothod = joinPoint.getSignature().getDeclaringTypeName() + '.' + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Requestlog requestlog = new Requestlog(url,ip,classMeothod,args);
        logger.info("Request:{}",requestlog);

    }
    @After("log()")
    public void  doAfter(){
        //logger.info("-------------doAfter");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void deAfterRuturn(Object result){
        logger.info("Result:{}",result);
    }

    private class Requestlog{
        private  String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public Requestlog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
