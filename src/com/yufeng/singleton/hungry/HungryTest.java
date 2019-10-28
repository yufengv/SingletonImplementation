package com.yufeng.singleton.hungry;



import java.lang.reflect.*;

/**
 * @author yufeng
 * @date 2019/10/24 - 17:57
 */
public class HungryTest {
    /**
     * 验证两次得到的对象是否是同一个
     * @param args
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton singleton1=Singleton.getSingleton();
        Singleton singleton2=Singleton.getSingleton();
        System.out.println(singleton1==singleton2);
        System.out.println(singleton1.equals(singleton2));
        //通过反射获取类的构造器
        Constructor constructor = Singleton.class.getDeclaredConstructor();
        //将修改权限设置为可行checkIndex(index);
        constructor.setAccessible(true);
        //通过构造器创建对象
        Singleton singleton3=(Singleton) constructor.newInstance();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton1.hashCode()==singleton3.hashCode());
    }
}
