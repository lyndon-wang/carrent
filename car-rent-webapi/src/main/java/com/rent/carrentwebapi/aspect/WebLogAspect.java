package com.rent.carrentwebapi.aspect;

import com.rent.carrentcommon.util.ParserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
@Aspect
public class WebLogAspect {

    /**
     * controller all method as pointcut
     */
    @Pointcut("execution(public * com.rent.carrentwebapi.controller..*.*(..))")
    public void webLog(){

    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methoName = proceedingJoinPoint.getSignature().getName();
        String remoteIp = request.getRemoteAddr();
        String requestArgs = ParserUtil.GSON.toJson(proceedingJoinPoint.getArgs());
        log.info("access in controller,URL:[{}],Http Method:[{}],Class Method:[{}.{}],IP:[{}],Request Args:[{}]",
                url,httpMethod,className,methoName,remoteIp,requestArgs);

        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long time = System.currentTimeMillis() - startTime;

        String resultStr = ParserUtil.GSON.toJson(result);
        String subStr = StringUtils.substring(resultStr, 0, 100);
        return result;

    }
}
