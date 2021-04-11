package com.jiaxu.state;

//测试守护线程
//上帝保护你
public class testDaemon {
    public static void main(String[] args) {

        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认是false表示是用户线程
        //正常线程都是用户线程

        thread.start();//开启守护线程
        new Thread(you).start();//开启用户线程...
    }
}

//上帝
class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑你");
        }
    }
}

//你
class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你开心的活着");
        }
        System.out.println("=========goodbye! world!======");

    }
}
