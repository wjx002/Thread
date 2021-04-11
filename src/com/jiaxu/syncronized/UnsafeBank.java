package com.jiaxu.syncronized;

//不安全的取钱
//两个人去银行取钱

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");

        Drawing wo = new Drawing(account, 50, "wo");
        Drawing girl = new Drawing(account, 100,"girl");

        girl.start();
        wo.start();



    }
}

//账户
class Account {
    //余额
    int money;
    //卡名
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public Account(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//银行：模拟取款

class Drawing extends Thread {

    Account account;//取钱账户

    //取了多少钱
    int drawingMoney;

    //手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }



    //取钱
    @Override
    public  void run() {

        synchronized (account) {
            //判断有没有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够了");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡的余额 = 余额 - 你取的钱
            account.money = account.money - drawingMoney;
            //手里的钱

            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "余额为：" + account.money);

            System.out.println(Thread.currentThread().getName() + "手里的钱" + nowMoney);


        }

        }
}