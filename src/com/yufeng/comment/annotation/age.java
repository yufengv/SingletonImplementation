package com.yufeng.comment.annotation;

import java.lang.annotation.*;

/**
 * @author yufeng
 * @date 2019/10/24 - 20:14
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//注解获取年龄
public @interface age {
    public int value() default 0;
}
