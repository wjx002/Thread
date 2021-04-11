package com.jiaxu.state;
//测试线程的优先级
public class testPriority {
    public static void main(String[] args) {

        //主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "---->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread thread1 = new Thread(myPriority);
        Thread thread2 = new Thread(myPriority);
        Thread thread3 = new Thread(myPriority);
        Thread thread4 = new Thread(myPriority);
        Thread thread5 = new Thread(myPriority);
        Thread thread6 = new Thread(myPriority);

        //设置优先级，在启动
        thread1.start();

        thread2.setPriority(1);
        thread2.start();


        thread3.setPriority(Thread.MAX_PRIORITY);
        thread3.start();

        thread4.setPriority(7);
        thread4.start();

        thread5.setPriority(4);
        thread5.start();

        thread6.setPriority(3);
        thread6.start();


    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        //输出线程的优先级
        System.out.println(Thread.currentThread().getName() + "----->" + Thread.currentThread().getPriority());
    }
}