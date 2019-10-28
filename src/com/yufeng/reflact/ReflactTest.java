package com.yufeng.reflact;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author yufeng
 * @date 2019/10/25 - 16:16
 */
public class ReflactTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Class clazz=Student.class;
        Constructor  constructor=clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println(list.add(1));
    }
}
