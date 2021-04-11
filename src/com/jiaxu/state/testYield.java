package com.jiaxu.state;

public class testYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "a").start();

        new Thread(myYield, "b").start();

    }
}


class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        //线程礼让
        //Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程终止执行");

    }
}