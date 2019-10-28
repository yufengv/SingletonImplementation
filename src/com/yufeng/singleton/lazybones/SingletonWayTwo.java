package com.yufeng.singleton.lazybones;

/**
 * @author yufeng
 * @date 2019/10/24 - 18:19
 */
public class SingletonWayTwo {
    private static SingletonWayTwo singletonWayTwo;

    private SingletonWayTwo() {
    }

    //同步方法锁确保线程安全
    synchronized public static SingletonWayTwo getInstance() {
        if (singletonWayTwo!=null) {
        } else
            {
            synchronized (SingletonWayOne.class) {
                if (singletonWayTwo == null) {
                    singletonWayTwo = new SingletonWayTwo();
                }
            }
        }
        return singletonWayTwo;
    }
}
