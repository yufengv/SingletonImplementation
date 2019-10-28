package com.yufeng.comment.annotation;

import java.lang.annotation.*;

/**
 * @author yufeng
 * @date 2019/10/25 - 8:55
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface introduction {
    public String name() default "";
    public int age() default 0;
}
