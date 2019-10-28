package com.yufeng.singleton.hungry;

/**
 * @author yufeng
 * @date 2019/10/24 - 17:50
 */
public class Singleton {
    //饿汉实现单例模式就是在类实现时立即加载
    private static Singleton singleton = new Singleton();

    private Singleton() {

    }
    public static  Singleton getSingleton()
    {
        return singleton;
    }
}
