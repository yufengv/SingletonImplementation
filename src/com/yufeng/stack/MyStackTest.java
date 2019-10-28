package com.yufeng.stack;

import javax.swing.*;
import javax.swing.plaf.synth.*;
import java.time.*;
import java.util.*;

/**
 * @author yufeng
 * @date 2019/10/26 - 22:09
 */
public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer>myStack=new MyStack<>();
        myStack.push(1);
        myStack.push(2);
       System.out.println(myStack.peek());
       System.out.println(myStack.peek());
       System.out.println(myStack.pop());
       System.out.println(myStack.pop());
       System.out.println(myStack.pop());

    }
}
