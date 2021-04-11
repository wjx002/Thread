package com.jiaxu.model.productAndConsumer;

//管程法
//生产者消费者模型

import java.awt.*;

public class process {
    public static void main(String[] args) {

        SynContainer synContainer = new SynContainer();
        new Product(synContainer).start();
        new Consumer(synContainer).start();
    }
}

//生产者
class Product extends Thread {
    //生产鸡
    SynContainer synContainer;

    public Product(SynContainer synContainer) {
        this.synContainer = synContainer;
    }


    //生产
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("生产了" + i + "只鸡");
            synContainer.push(new Chicken(i));
        }
                
    }
}


//消费者
class Consumer extends Thread {

    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第"+synContainer.pop().id+"只鸡");
        }
    }
}

//产品
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


//缓冲区
class SynContainer {
    //放产品的地方
    //对象数组 指定大小
    Chicken[] chickens = new Chicken[10];
    //统计鸡的数量
    int account = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken)  {

        //鸡放满了，只能消费 生产停止
        if (account >= chickens.length-1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //否则就没有满
        //没有满就继续放鸡
        chickens[account] = chicken;
        account++;
        //通知消费者消费
        this.notifyAll();

    }

    //消费者放入产品

    public synchronized Chicken pop()  {
        //如果没有鸡了，消费者停止
        if (account <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        account--;
        Chicken chicken = chickens[account];

        //唤醒生产者
        this.notifyAll();

        return chicken;
    }


}