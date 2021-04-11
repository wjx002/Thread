package com.jiaxu.lock;

//死锁：一个同步块拥有两个或两个以上的对象的锁，才有可能发生
//互相占有其他线程需要的资源，等待其他线程释放资源才可以运行，
//导致停止执行的情形
public class DeadLock {
    public static void main(String[] args) {

        MakeUp person1 = new MakeUp(0, "火姑娘");
        MakeUp person2 = new MakeUp(1, "白雪公主");

        person1.start();
        person2.start();
    }
}

//化妆品类
class Lipstick{

}


//镜子类
class Mirror {

}

//化妆执行
class MakeUp extends Thread {

    //保证需要的资源只有一份，用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    //选择
    int choice;
    //化妆的人
    String girl;

    public MakeUp(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }


    @Override
    public void run() {
        //运行化妆方法

        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆方法
    private void makeup() throws InterruptedException {
        if (choice == 0) {

            //开始化妆
            synchronized (lipstick) {
                //获取到了口红的锁
                System.out.println(this.girl + "拿到了口红的锁");
                Thread.sleep(1000);

            }
            synchronized (mirror) {
                //获取到了镜子的锁
                System.out.println(this.girl + "拿到了镜子的锁");
            }
        } else {
            //开始化妆
            synchronized (mirror) {
                //获取到了镜子的锁
                System.out.println(this.girl + "拿到了镜子的锁");
                Thread.sleep(1000);

            }
            synchronized (lipstick) {
                //获取到了口红的锁
                System.out.println(this.girl + "拿到了口红的锁");
            }
        }
    }
}
