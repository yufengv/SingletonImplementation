package com.yufeng.reflact;

import java.lang.annotation.*;

/**
 * @author yufeng
 * @date 2019/10/28 - 9:46
 */
public class UserCase {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UserCases
    {

    }
}
