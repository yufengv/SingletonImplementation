package com.yufeng.singleton.staticpieces;

/**
 * @author yufeng
 * @date 2019/10/24 - 18:40
 */
public class Test {
    /**
     * 用于测试是否属于同一对象
     * @param args
     */
    public static void main(String[] args) {
        Singleton singleton1=Singleton.getSingleton();
        Singleton singleton2=Singleton.getSingleton();
        System.out.println(singleton1==singleton2);
        System.out.println(singleton1.equals(singleton2));
    }
}
