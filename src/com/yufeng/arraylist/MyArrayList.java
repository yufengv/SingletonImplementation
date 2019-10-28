package com.yufeng.arraylist;


import com.sun.javafx.image.*;
import sun.plugin.javascript.navig.*;

import javax.lang.model.util.*;
import java.util.*;

/**
 * @author yufeng
 * @date 2019/10/25 - 20:20
 */
public class MyArrayList<T > implements List<T>,Comparable<T>{
    //定义数组的初始长度
    private  static final  int DEFAULT_CAPACITY=10;
    //定义list的长度指标
    private   int theSize;
    //定义一个数组用来存储数据
    private  T[] theItems;
    //在构造函数时初始化数组值
    public  MyArrayList()
    {
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }
    @Override
    public int size() {
        return theSize;
    }

    @Override
    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return theSize==0;
    }

    @Override
    /**
     * 判断元素是否存在
     */
    public boolean contains(Object o) {

        return indexOf(o)>=0;
        //int start=0;
        //int end=size()-1;
      //int flag=BinarySearch(start,end, o);
      //if(flag<0)
     // {
          //return  false;
      //}
     // return  true;
    }
//二分查找判断值是否存在
    /*public int BinarySearch(int start,int end,Object o) {
       Arrays.sort(theItems);//首先对数组进行排序
        int mid = (end - start) / 2;
       if (start > end) {
            return -1;
        }

        if (theItems[mid].equals(o))
       {
             return mid;
       }
       else if(theItems[mid].compareTo((T)o)<0)
        {
            return BinarySearch(mid+1,end,o);
        }
       else
        {
            return BinarySearch(start,mid-1,o);
        }
    }*/

    @Override
    public Iterator<T> iterator() {
        //返回一个迭代对象
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {

        return null;
    }

    @Override
    public boolean add(T e) {
        add(size(),e);
        return true;
    }

    @Override
    /**
     * 移除元素
     */
    public boolean remove(Object o) {
        int count=0;
        contains(o);//判断元素是否存在
        for(int i=0;i<size();i++)
        {
            if(theItems[i].equals(o))
            {
                if(i==size()-1)//判断是否到最后一个元素
                {
                    theSize--;
                    count++;
                }
                else {
                    theItems[i] = theItems[i + 1];
                    theSize--;
                    count++;
                }

            }
        }
        if(count!=0)
        {
           return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    /**
     * 添加所有元素
     */
    public boolean addAll(Collection<? extends T> c) {
        T []toArray =(T[])c.toArray();
        int count=0;
        for(int i=0;i<toArray.length;i++)
        {
            add(toArray[i]);
            count++;
        }
        if(count==toArray.length)
        {
            return true;
        }
        return false;
    }

    @Override
    /**
     * 在指定位置添加所有元素
     */
    public boolean addAll(int index, Collection<? extends T> c) {
        T[]ts=(T[])c.toArray();
        int count=0;
        for(int i=0;i<ts.length;i++)
        {
            add(index,ts[i]);
            index++;
            count++;
        }
        if(count==ts.length)
        {
            return true;
        }
        return false;
    }

    @Override
    /**
     * 删除所有元素
     * 目前所写的方法不能保证元素是否都删出
     * 原因：1.有的元素不存在
     *      2. 所有的元素不存在
     *      由于这两个指标的存在导致无法判断是否已经删除
     *      后续查看源码改进
     */

    public boolean removeAll(Collection<?> c) {

         T[]arry=(T[])c.toArray();
         int notDeleteCount=0;
         int deleteCount=0;
         for(int i=0;i<arry.length;i++)
         {
             if(remove(arry[i]))
             {
                 deleteCount++;
             }
             else
             {
                 notDeleteCount++;
             }
         }
       if(deleteCount+notDeleteCount==arry.length)//判断数组的长度是否与删除和未删除的数量相同
       {
           return  true;
       }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    @Override
    /**
     * 返回指定位置的值
     */
    public T get(int index) {
        checkIndex(index);
        return  theItems[index];
    }

    @Override
    //更换指定位置的值
    public T set(int index, T element) {
        checkIndex(index);
        T oldValue=theItems[index];
        theItems[index]=element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
         if(theItems.length==size())
         {
             ensureCapacity((size()*3)/2+1);//扩充容量为原来的1.5倍+1
         }
         else
         {
             //在数组中间插入数字
             for(int i=theSize;i>index;i--)
             {
                 theItems[i]=theItems[i-1];
             }
         }
         theItems[index]=element;
         theSize++;
    }

    @Override
    /**
     * 删除指定位置的元素
     */
    public T remove(int index) {
        checkIndex(index);//先进行检查
        T deleteValue=theItems[index];
        for(int i=index;i<size();i++)//将后面的元素向前一位
        {
            theItems[i]=theItems[i+1];
        }
        theSize--;//将数组长度减1
        return deleteValue;
    }

    @Override
    //获得元素首次出现的位置
    public int indexOf(Object o) {
        //如果是对象有可能是null
        if(o==null)
        {
            for(int i=0;i<size();i++)
            {
                if(theItems[i]==o)
                {
                    return  i;
                }
            }
        }
        else
        {
            for(int i=0;i<size();i++)
            {
                if(theItems[i].equals(o))
                {
                    return  i;
                }
            }
        }
        return -1;
    }
    @Override
    //返回数组最后出现的位置倒序遍历
    public int lastIndexOf(Object o) {
        if(o==null)
        {
            for(int i=size()-1;i>=0;i--)
            {
                if(theItems[i]==o)
                {
                    return  i;
                }
            }
        }
        else
        {
            for(int i=size()-1;i>=0;i--)
            {
                if(theItems[i].equals(o))
                {
                    return  i;
                }
            }
        }
        return -1;
    }
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }
    @Override
    /**
     * 返回截取后的list
     * ------后续需要改进
     */
    public List<T> subList(int fromIndex, int toIndex) {
        List<T>list=new MyArrayList<T>();
        for(int i=fromIndex;i<toIndex;i++)
        {
            list.add(theItems[i]);
        }
        return  list;
    }

    /**
     * 判断截取时是否超出数组界限
     * @param fromIndex
     * @param toIndex
     */
    public void checkIndex(int fromIndex, int toIndex)
    {
        if(toIndex-fromIndex<0)
        {
            throw  new IndexOutOfBoundsException("输入区间有误");
        }
        else if(fromIndex<0)//超出界限
        {
             throw  new IndexOutOfBoundsException("超出界限");
        }
        else if(toIndex>=size())
        {
            throw  new IndexOutOfBoundsException("超出界限");
        }
    }
    /**
     * 扩充容量之后的操作
     * @param newCapacity
     */
    public void ensureCapacity(int newCapacity)
    {
         if(newCapacity<size())
         {
             return;
         }
         else
         {
             //定义一个数组承接数组值
             T[] old=theItems;
             //将数组容量扩充
             theItems=(T[])new Object[newCapacity];
             //赋值
             for(int i=0;i<size();i++)
             {
                 theItems[i]=old[i];
             }

         }
    }
    /**
     * 用来检查输入的元素位置是否存在
     * @param index
     */
    public void checkIndex(int index)
    {
        if(index<0||index>=theSize)
        {
            throw new ArrayIndexOutOfBoundsException();//超出界限
        }
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }

    //实现迭代器
    class Itr implements Iterator<T>{
        private int afterIndex; //下一个位置
        private int beforeIndex = -1; //前一个位置

        @Override
        public boolean hasNext() {
            return afterIndex != theSize;//如果下一个位置等于数组的长度，表示没有
        }

        @Override
        public T next() {
            int i = afterIndex;
            afterIndex += 1;//将下一个指标+1
            if (i > theSize){
                throw new IndexOutOfBoundsException("越界异常");
            }
            T num = theItems[i];//获取当前值
            beforeIndex = i;
            return num;//返回当前值
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(beforeIndex);
            afterIndex = beforeIndex;
            beforeIndex = -1;
        }
    }
}
