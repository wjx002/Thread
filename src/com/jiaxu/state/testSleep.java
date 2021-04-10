package com.jiaxu.state;

//模拟网络延时: 放大问题的发生性


import com.jiaxu.demo01.Race;

public class testSleep implements Runnable{

    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {

            if (ticketNums <= 0) {
                break;

            }
            //模拟延时

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "票");

        }
    }

    public static void main(String[] args) {
        testSleep testSleep = new testSleep();
        new Thread(testSleep,"小米").start();
        new Thread(testSleep,"老师").start();
        new Thread(testSleep, "黄牛党").start();

    }
}
