package com.jiaxu.state;


//测试stop
//1.建议线程正常停止---->利用次数，不建议死循环
//建议使用标志位----->设置一个标志位
//3.不要使用stop或者destroy等过时或者JDk不建议使用的方法
public class testStop  implements Runnable {


    //1.设置一个标志位
    boolean flag = true;


    //转换标志位
    public void stop() {
        this.flag = false;
    }

    @Override
    public void run() {

        int i = 0;
        if (flag) {
            System.out.println("run Thread " + i++);
        }
    }

    public static void main(String[] args) {
        //创建线程对象
        testStop testStop = new testStop();
        Thread thread = new Thread(testStop);
        //开启线程
        thread.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("main线程" + i);
            if (i == 9900) {
                //当主线程i等于990时，停止线程
                testStop.stop();
                System.out.println("线程终止了");
            }

            ;
        }

    }
}
