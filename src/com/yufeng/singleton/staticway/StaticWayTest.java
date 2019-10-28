package com.yufeng.singleton.staticway;

/**
 * @author yufeng
 * @date 2019/10/24 - 18:34
 */
public class StaticWayTest {
    public static  void main(String []args)
    {
        Singleton singleton1=Singleton.getInstance();
        Singleton singleton2=Singleton.getInstance();
        System.out.println(singleton1==singleton2);
        System.out.println(singleton1.equals(singleton2));
    }
}
