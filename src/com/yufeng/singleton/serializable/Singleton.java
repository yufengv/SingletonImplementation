package com.yufeng.singleton.serializable;

import java.io.*;

/**
 * @author yufeng
 * @date 2019/10/24 - 18:45
 */
public class Singleton implements Serializable{
    private static final long serialVersionUID = 888L;

    // 内部类方式
    private static class MyObjectHandler {
        private static final Singleton singleton = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return MyObjectHandler.singleton;
    }

    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return Singleton.getInstance();
    }

}
