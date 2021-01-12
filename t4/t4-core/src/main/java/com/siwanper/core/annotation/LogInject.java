package com.siwanper.core.annotation;

import java.lang.annotation.*;

/**
 * 名称：LogInject
 * 描述：自定义注解，实现注解日志类
 *
 * @author chenjie
 * @date 2020/11/21  10:16 上午
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface LogInject {
}
