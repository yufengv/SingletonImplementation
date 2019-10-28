package com.yufeng.stack;

import com.yufeng.arraylist.*;
import sun.awt.*;

import java.util.*;

/**
 * @author yufeng
 * @date 2019/10/26 - 21:21
 */
public class MyStack<T >  extends MyArrayList<T> {
    /**
     * 压栈操作
     * @param elem
     * @return
     */
    public T push(T elem) {
        add(elem);
        return elem;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty()
    {
        return size()==0;
    }

    /**加入同步锁保证线程安全
     * 返回栈顶值并且删除该值
     * @return
     */
    public synchronized T pop()
    {
        if(isEmpty())
        {
            throw  new EmptyStackException();
        }
        T e=peek();
        remove(size()-1);//移除顶层元素
        return e;

    }
    /**加入同步锁保证线程安全
     * 返回栈顶值，但并不删除元素值
     * @return
     */
    public synchronized T peek()
    {
        if(isEmpty())
        {
            throw  new EmptyStackException();
        }
        else
        {
            return get(size()-1);
        }
    }
}
