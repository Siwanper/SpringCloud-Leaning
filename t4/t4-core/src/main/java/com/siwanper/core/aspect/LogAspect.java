package com.siwanper.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 名称：LogAspect
 * 描述：面向切面实习控制器方法日志。
 *
 * @author chenjie
 * @date 2020/11/21  9:17 上午
 */
@Component
@Aspect
@Order(3)
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut(value = "execution(* com.siwanper..*.controller..*.*(..))")
    public void pointCut(){
    }

    @Before(value = "pointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        if (args.size() > 0) {
            logger.debug("Siwanper --> [LogAspect 前置通知] 类名：" + className + " 方法：" + methodName + "参数："+ args);
        } else {
            logger.debug("Siwanper --> [LogAspect 前置通知] 类名：" + className + " 方法：" + methodName);
        }
    }

    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        if (args.size() > 0) {
            logger.debug("Siwanper --> [LogAspect 后置通知] 类名：" + className + " 方法：" + methodName + "参数："+ args);
        } else {
            logger.debug("Siwanper --> [LogAspect 后置通知] 类名：" + className + " 方法：" + methodName);
        }
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        if (args.size() > 0) {
            logger.debug("Siwanper --> [LogAspect 后置返回通知] 类名：" + className + " 方法：" + methodName + "参数：" + args + " 返回：" + result);
        } else {
            logger.debug("Siwanper --> [LogAspect 后置返回通知] 类名：" + className + " 方法：" + methodName + " 返回：" + result);
        }
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception exception){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        if (args.size() > 0) {
            logger.debug("Siwanper --> [LogAspect 后置异常通知] 类名：" + className + " 方法：" + methodName + "参数：" + args + " 异常：" + exception.getMessage());
        } else {
            logger.debug("Siwanper --> [LogAspect 后置异常通知] 类名：" + className + " 方法：" + methodName + " 异常：" + exception.getMessage());
        }
    }
}
