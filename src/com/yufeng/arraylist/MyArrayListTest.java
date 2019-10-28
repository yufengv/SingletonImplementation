package com.yufeng.arraylist;

import java.util.*;

/**
 * @author yufeng
 * @date 2019/10/25 - 21:54
 */
public class MyArrayListTest {


    public static void main(String[] args) {
        MyArrayList<Integer>list=new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.subList(0,1);
        List<Integer>list2=new MyArrayList<>();
        list2=list.subList(0,1);//未能实现（需要重新创建对象,需要改进）
        Iterator<Integer>it2=list2.iterator();
         list.contains(2);
        while(it2.hasNext())
        {
            System.out.println(it2.next());
        }
      // for(int i=0;i<list.size();i++)
        System.out.println(list.contains(1));
      //  System.out.println(list.contains(4));
        System.out.println(list.size());
        list.remove(1);
      Iterator<Integer>it=list.iterator();
      while(it.hasNext())
      {
          System.out.println(it.next());
      }
      list.clear();
    }
}
