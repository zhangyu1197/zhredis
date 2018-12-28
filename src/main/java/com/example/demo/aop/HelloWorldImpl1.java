package com.example.demo.aop;

import org.springframework.stereotype.Component;

/**
 * @author zypcid
 * @Title: HelloWorldImpl1
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/189:09
 */
@Component
public class HelloWorldImpl1 implements HelloWorld
{
    @Override
    public void printHelloWorld()
    {
        System.out.println("Enter HelloWorldImpl1.printHelloWorld()");
    }

    @Override
    public void doPrint()
    {
        System.out.println("Enter HelloWorldImpl1.doPrint()");
    }
}
