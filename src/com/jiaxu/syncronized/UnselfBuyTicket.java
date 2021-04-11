package com.jiaxu.syncronized;

public class UnselfBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"小米").start();
        new Thread(buyTicket,"小孩").start();
        new Thread(buyTicket,"黄牛").start();
    }
}

class BuyTicket implements Runnable {

    //票数
    int ticket = 10;
    //标志位
    boolean flag = true;

    private synchronized void buy() throws InterruptedException {
        //买票
        if (ticket <= 0) {
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        //买一张就少一张
        System.out.println(Thread.currentThread().getName() + "买了第" + ticket-- + "张票");


    }
    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
