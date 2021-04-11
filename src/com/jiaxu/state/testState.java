package com.jiaxu.state;

public class testState {

    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("//////////");

        });


        //观察状态
        Thread.State state = thread.getState();
        //输出状态
        System.out.println(state);

        //观察启动后
        thread.start();
        state = thread.getState();//更新状态
        System.out.println(state);

        //只要线程不结束，则一直输出线程状态
        while (state != Thread.State.TERMINATED) {


            try {
                thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //更新线程状态
            state = thread.getState();
            //输出线程状态
            System.out.println(state);
        }
    }
}
