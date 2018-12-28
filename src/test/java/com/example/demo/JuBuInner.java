package com.example.demo;

/**
 * @author zypcid
 * @Title: JuBuInner
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/1715:52
 */
public class JuBuInner
{
    public static void main(String[] args)
    {
        final int i=1;
        class A
        {
            public void print()
            {
                System.out.println("AAA,i="+i);
            }
        }
        A a=new A();
        a.print();

    }
}
