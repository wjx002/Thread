package com.jiaxu.lock;

import java.text.BreakIterator;
import java.util.concurrent.locks.ReentrantLock;

public class reenTrantLock {
    public static void main(String[] args) {
        BuyTickey buyTickey = new BuyTickey();
        new Thread(buyTickey).start();
        new Thread(buyTickey).start();
        new Thread(buyTickey).start();

    }

}

//还是用买火车票的例子

class BuyTickey implements Runnable {


    int ticketNum = 10;
    //定义可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticketNum <= 0) {
                    break;

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(ticketNum--);
            }finally {
                lock.unlock();
            }
        }
    }
}
