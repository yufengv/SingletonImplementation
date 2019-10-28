package com.yufeng.comment.annotation;

import sun.awt.*;

import java.lang.reflect.*;

/**
 * @author yufeng
 * @date 2019/10/24 - 20:11
 */
public class AnnotionsUtils {
    public static String getInfo(Class<?> cs){
        String result = "";
        Field[] declaredFields = cs.getDeclaredFields();//获取所有类中声明的对象
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Name.class)) {
                Name annotation = field.getAnnotation(Name.class);
                String value = annotation.value();//获取相对应的值
                result += (field.getName() + ":" + value + "\n");
            }
            if (field.isAnnotationPresent(age.class)) {//通过反射获取相对应的类
                age annotation = field.getAnnotation(age.class);
                int value = annotation.value();
                result += (field.getName() + ":" + value + "\n");
            }
            if(field.isAnnotationPresent(introduction.class))
            {
                introduction annotion=field.getAnnotation(introduction.class);
                String introduction=annotion.name()+annotion.age();
                result+=(field.getName()+":"+ introduction+"\n");
            }
        }
        return result;
    }
    public static void main(String[] args){
        String info = getInfo(Person.class);
        System.out.println(info);
    }
}
