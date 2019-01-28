package com.zykj.springboot_example.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/*
 *使用AOP统一处理web请求日志
 *
 */
@Component
@Aspect
public class WebLogAspect {
    //注意此处org.apache.log4j.Logger是不是线程安全的，要去确定
    private static final Logger logger = Logger.getLogger(WebLogAspect.class);


    @Pointcut("execution(public * com.zykj.springboot_example.controller.*.*(..)) && " +
            "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        //获取HttpServletRequest对象
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();

        StringBuilder stringBuilder = new StringBuilder();
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = httpServletRequest.getParameter(name);
            stringBuilder.append(name + "=" + value + "&");
        }
        if (stringBuilder.length() >= 2) {
            String substring = stringBuilder.substring(0, stringBuilder.length() - 2);
            if (logger.isInfoEnabled()) {
                logger.info("request=> URL:" + httpServletRequest.getRequestURL().toString() +
                        " ip:" + httpServletRequest.getRemoteAddr() +
                        " param:" + substring);
            }
        } else {
            if (logger.isInfoEnabled()) {
                logger.info("request=> URL:" + httpServletRequest.getRequestURL().toString() +
                        " ip:" + httpServletRequest.getRemoteAddr());
            }
        }
    }

    @AfterReturning(pointcut = "webLog()", returning = "returnValue")
    public void doAfterReturing(Object returnValue) {
        if (logger.isInfoEnabled()) {
            logger.info("reponse=> " + returnValue);
        }
    }


}
