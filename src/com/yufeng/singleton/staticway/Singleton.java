package com.yufeng.singleton.staticway;

/**
 * @author yufeng
 * @date 2019/10/24 - 18:30
 */
public class Singleton {
    //内部类方式
    private  static  class  SingletonHandler{
        private  static  Singleton singleton=new Singleton();
    }
    private Singleton()
    {}
    public static  Singleton getInstance()
    {
        return SingletonHandler.singleton;
    }

}
