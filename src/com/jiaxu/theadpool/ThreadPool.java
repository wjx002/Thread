package com.jiaxu.theadpool;

//测试线程池


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
       //1.创建服务，创建线程池
       //Executors.newFixedThreadPool(10)参数是线程池的大小
        ExecutorService service = Executors.newFixedThreadPool(10);


        //执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //关闭连接
        service.shutdown();
    }
}


class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}