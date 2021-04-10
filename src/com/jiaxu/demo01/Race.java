package com.jiaxu.demo01;

//龟兔赛跑
/*
1. 首先定一个赛道距离，然后要离终点越来越近
2. 判断比赛是否结束
3. 打印出胜利者
4. 龟兔赛跑开始
5. 故事中是乌龟赢的，兔子要睡觉，所以我们来模拟兔子睡觉
6. 终于，乌龟赢得了比赛

 */

public class Race implements Runnable{


    private static String winner;


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            //模拟一下兔子休息
            if (Thread.currentThread().getName().equals("兔子") && i % 20 == 0) {
                try {
                    Thread.sleep(1);
                    System.out.println("兔子想睡觉");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            //判断是否游戏结束，true则是出现胜利者了
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            if (Thread.currentThread().getName().equals("兔子")) {
                i+=5;
            }

            System.out.println(Thread.currentThread().getName()+"跑了----->"+i+"步");
        }
    }



    private boolean gameOver(int steps) {

        //判断有没有胜利者
        if (winner != null) {
            return true;
        }
        //出现胜利者了
        if (steps == 100) {
            //获取胜利者名字
            winner = Thread.currentThread().getName();
            //输出胜利者是谁
            System.out.println("winner is " + winner);

            return true;
        }

        return false;
    }



    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
