package com.example.demo;

/**
 * @author zypcid
 * @Title: Outer
 * @ProjectName zhredis
 * @Description: 内部类中不能有静态变量
 * @date 2018/12/1715:38
 */
public class Outer
{
    private int i;
    public Outer(int i)
    {
        this.i=i;
    }
    public void privateInnerGetI()
    {
        new PrivateInner().printI();
    }
    private class PrivateInner
    {

        public void printI()
        {
            System.out.println(i);
        }
    }
    public class PublicInner
    {

        private int i=2;
        public void printI()
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args)
    {
        Outer outer=new Outer(1);
        outer.privateInnerGetI();
        outer.new PrivateInner().printI();
        outer.new PublicInner().printI();
    }
}
