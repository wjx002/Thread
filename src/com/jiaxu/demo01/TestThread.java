package com.jiaxu.demo01;


//创建线程的方法一：
//继承Thread类，重写run()方法，调用start开启线程
//总结：注意线程不一定立即执行，由CPU调度执行
public class TestThread extends Thread {
    //重写run方法

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码，重写run方法"+i);
        }
    }


    //调用主线程main
    public static void main(String[] args) {
        //创建一个线程对象
        TestThread testThread = new TestThread();

        //调用start()方法开启线程
        testThread.start();

        //主线程运行
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程  " + i);
        }
    }
}
