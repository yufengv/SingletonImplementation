package com.yufeng.singleton;

/**
 * @author yufeng
 * @date 2019/10/24 - 20:40
 */
import java.lang.reflect.*;
/**
 * 反射破坏单例
 */
public class Relface {
    private Relface() {
    }
    private static class SingletonIns {

        private static final Relface INSTANCE = new Relface();
    }

    public static Relface getInstance() {
        return SingletonIns.INSTANCE;
    }

    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Relface s1 = Relface.getInstance();
        System.out.println(s1);
        /**
         * 通过反射破坏单例模式
         */
        //反射获得单例类的构造函数
        /**
         * 通过反射获取类的信息
         */
        Constructor<Relface> constructor = Relface.class.getDeclaredConstructor();
        //指示反射的对象在使用时取消Java语言访问检查，绕过private Singleton6()
        constructor.setAccessible(true);
        Relface s2 = constructor.newInstance();
        System.out.println(s2);

    }

}
