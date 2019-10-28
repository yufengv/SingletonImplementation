package com.yufeng.comment.annotation;

import sun.awt.*;

/**
 * @author yufeng
 * @date 2019/10/24 - 19:32
 */

public class Person {
   @Name(value = "张三")
    public String name;
   @age(value=20)
    public int age;
   @introduction(name = "李四",age=20)
   public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
