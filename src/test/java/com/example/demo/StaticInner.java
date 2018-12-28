package com.example.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zypcid
 * @Title: StaticInner
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/1716:02
 */
public class StaticInner
{
    private static  int i=1;
    static class Inner
    {
       public void notStaticPrint()
       {
           System.out.println("staticInner.notStaticPrint(),i="+i);
       }
       public static void staticPrint()
       {
           System.out.println("staticInner.staticPrint()");
       }
    }

    public static void main(String[] args)
    {
        StaticInner.Inner inner=new StaticInner.Inner();
        inner.notStaticPrint();

    }
}
