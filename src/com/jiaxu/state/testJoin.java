package com.jiaxu.state;

//测试join方法
//想象成插队

import com.sun.javafx.sg.prism.web.NGWebView;

public class testJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        testJoin testJoin = new testJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            if (i == 200) {
                thread.join();
            }
            System.out.println("main线程"+i);
        }
    }
}
