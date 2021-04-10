package com.jiaxu.demo01;


//静态代理
public class staticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany= new WeddingCompany(new You());
        weddingCompany.marry();

        new Thread(() -> System.out.println("我爱你")).start();
    }

}
//写个接口让代理和真实角色去实现
//比如结婚
interface Marry {
    void marry();
}

//真实角色 就是你了
class You implements Marry {

    //对接口进行实现
    //真实角色就做自己的事情就好了
    @Override
    public void marry() {
        System.out.println("我要结婚了");
    }
}


//代理角色，把你处理结婚事务
class WeddingCompany implements Marry {

    //代理谁 去结婚
    private Marry target;

    @Override
    public void marry() {
        before();
        target.marry();
        after();
    }

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    private void before() {
        System.out.println("结婚前，布置婚礼现场");
    }

    private void after() {
        System.out.println("结婚后，收取尾款");
    }
}