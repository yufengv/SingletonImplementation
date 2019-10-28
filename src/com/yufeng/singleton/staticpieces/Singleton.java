package com.yufeng.singleton.staticpieces;

/**
 * @author yufeng
 * @date 2019/10/24 - 18:38
 */
public class Singleton {
    private  static  Singleton singleton;
    private  Singleton(){}
    //使用代码块实现单例对象
    static {
        singleton=new Singleton();
    }
    public  static  Singleton getSingleton()
    {
        return  singleton;
    }
}
