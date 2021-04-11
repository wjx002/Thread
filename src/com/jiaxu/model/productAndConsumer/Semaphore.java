package com.jiaxu.model.productAndConsumer;

import com.sun.org.apache.bcel.internal.generic.NEW;

//信号灯法
//通过一个flag来调度
public class Semaphore {
    public static void main(String[] args) {
        TV tv = new TV();
        new Actor(tv).start();
        new watch(tv).start();

    }
}

//演员
class Actor extends Thread {

    TV tv;

    public Actor(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {

                this.tv.play("快乐大本营");
            } else {
                this.tv.play("抖音：记录美好生活");

            }
        }
    }
}

//观看者
class watch extends Thread {
    TV tv;

    public watch(TV tv) {
        this.tv = tv;
    }



    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            this.tv.watch();

        }

    }
}

//电视剧
class TV {
    //演员表演，观众等待 T
    //观众观看，演员等待F
    String vedio;

    boolean flag = true;

    //表演
    public synchronized void play(String vedio) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("演员表演了：" + vedio);
        //通知观众观看
        this.notify();
        this.vedio = vedio;
        this.flag = !this.flag;
    }

    //观看
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("观众观看了：" + vedio);
        //通知演员表演
        this.notifyAll();
        this.flag = !this.flag;

    }


}
