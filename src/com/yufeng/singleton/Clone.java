package com.yufeng.singleton;

import java.io.*;
import java.lang.reflect.*;

/**
 * @author yufeng
 * @date 2019/10/24 - 20:45
 */

public class Clone implements Serializable,Cloneable {
    private final static Clone clone;

    static{
        clone = new Clone();//静态块声明一个对象
    }

    private Clone(){//防止反射破会单例
        if(clone != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    /**
     * 得到单例
     * @return
     */
    public static Clone getInstance(){
        return clone;
    }

    /**防止反序列化对单例模式的破坏
     * 反序列化的对象的类存在readResolve这个方法，他会调用这个方法来返回一个“array”
     * ，然后浅拷贝一份，作为返回值，并且无视掉反序列化的值，即使那个字节码已经被解析。
     * @return
     */
    private Object readResolve(){
        return clone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
    public static void main(String[] args) throws CloneNotSupportedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {



        Clone hungrySingleton = Clone.getInstance();
        /**
         * 尝试使用反射
         */
        Method method = hungrySingleton.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        Clone cloneHungrySingleton = (Clone) method.invoke(hungrySingleton);
        System.out.println(hungrySingleton);
        System.out.println(cloneHungrySingleton);
    }



}
