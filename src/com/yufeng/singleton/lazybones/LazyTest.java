package com.yufeng.singleton.lazybones;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.*;
import com.yufeng.singleton.hungry.*;

/**
 * @author yufeng
 * @date 2019/10/24 - 18:17
 */
public class LazyTest {
    /**
     *用于判断是否是同一对象
     * @param args
     */
    public static void main(String[] args) {
       SingletonWayOne singleton1=SingletonWayOne.getInstance();
       SingletonWayOne singleton2=SingletonWayOne.getInstance();
       SingletonWayTwo singletonWayTwo1=SingletonWayTwo.getInstance();
       SingletonWayTwo singletonWayTwo2=SingletonWayTwo.getInstance();
       System.out.println(singleton1==singleton2);
       System.out.println(singleton1.equals(singleton2));
       System.out.println(singletonWayTwo1==singletonWayTwo2);
       System.out.println(singletonWayTwo2.equals(singletonWayTwo1));
    }
}
