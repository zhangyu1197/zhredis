package com.example.demo;

/**
 * @author zypcid
 * @Title: ThreadSynchronized
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/1714:58
 */
public class ThreadSynchronized
{

    public static void main(String[] args)
    {

    }
    public void init()
    {
        Outputer outputer=new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                while(true)
                {
                    try
                    {
                        Thread.sleep(10);
                        outputer.output("zhangxiaoxiang");
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    class Outputer{
        public void output(String name)
        {
            int len=name.length();
            for(int i=0;i<len;i++)
            {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
