package com.example.demo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author zypcid
 * @Title: TimerTest
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/1710:30
 */
public class TimerTest
{
    public static void main(String[] args)
    {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("boom");
                System.out.println(Thread.currentThread().getName());
            }
        }, 10000,3000);
        while(true)
        {
            System.out.println(new Date().getSeconds());
            System.out.println(Thread.currentThread().getName());
            try
            {
                Thread.sleep(1000);

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
