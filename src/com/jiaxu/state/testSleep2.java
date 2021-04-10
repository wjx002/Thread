package com.jiaxu.state;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class testSleep2 {

    public static void timeDown() throws InterruptedException {
        int num = 10;
        while (true) {

            Thread.sleep(1000);
            System.out.println(num--);

            if (num <= 0) {
                break;

            }
        }
    }

    public static void main(String[] args) {
        //打印当前系统时间
        //获取当前系统时间
        Date startTime = new Date(System.currentTimeMillis());

        while (true) {

            try {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));

                Thread.sleep(1000);
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
