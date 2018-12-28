package com.example.demo.aop;

import org.springframework.stereotype.Component;

/**
 * @author zypcid
 * @Title: HelloWorldImpl2
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/189:11
 */
@Component
public class HelloWorldImpl2 implements HelloWorld
{
    @Override
    public void printHelloWorld()
    {
        System.out.println("Enter HelloWorldImpl2.printHelloWorld()");
    }

    @Override
    public void doPrint()
    {
        System.out.println("Enter HelloWorldImpl2.doPrint()");
    }
}
