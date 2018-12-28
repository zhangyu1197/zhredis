package com.example.demo;
/**
 * @author zypcid
 * @Title: ReferenceTest
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/2823:16
 */
public class ReferenceTest
{
    public static void main(String[] args)
    {
        Hello[] hellos=new Hello[5];
        Hello hello=hellos[3];
        Hello hell3=new Hello();
        hellos[3]=hell3;
        System.out.println(hellos[3]);
        System.out.println(hello);
    }
}
