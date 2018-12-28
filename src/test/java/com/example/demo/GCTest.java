package com.example.demo;

/**
 * @author zypcid
 * @Title: GCTest
 * @ProjectName zhredis
 * @Description: TODO
 * @date 2018/12/179:22
 */
public class GCTest
{
    private Object instance=null;
    private static final int _1MB=1024*1024;
    private byte[] bigSize=new byte[2*_1MB];

    public static void main(String[] args)
    {
        GCTest gca=new GCTest();
        GCTest gcb=new GCTest();
        gca.instance=gcb;
        gcb.instance=gca;
        gca=null;
        gcb=null;
        System.gc();
    }
}
