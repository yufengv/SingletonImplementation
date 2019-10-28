package com.yufeng.singleton.lazybones;


/**
 * @author yufeng
 * @date 2019/10/24 - 18:03
 */
public class SingletonWayOne {

    private static SingletonWayOne singletonWayOne;

    private SingletonWayOne() {
    }

    //同步方法锁确保线程安全
    synchronized public static SingletonWayOne getInstance() {
        if (singletonWayOne == null) {
        } else {
            singletonWayOne = new SingletonWayOne();
        }
        return singletonWayOne;
    }
}
