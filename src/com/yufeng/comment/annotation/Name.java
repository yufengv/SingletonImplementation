package com.yufeng.comment.annotation;

import java.lang.annotation.*;

/**用于自我介绍的注解
 * @author yufeng
 * @date 2019/10/24 - 19:06
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//注解得到name的值
public @interface Name {
    public  String  value() default "";
}
