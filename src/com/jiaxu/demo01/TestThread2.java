package com.jiaxu.demo01;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread{

    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {

        WebDownloader webDownloader = new WebDownloader();
        try {
            webDownloader.download(url, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("下载的文件名：" + name);
    }

    public static void main(String[] args) {

        TestThread2 t1 = new TestThread2("https://b-ssl.duitang.com/uploads/item/201612/07/20161207082313_mN2iJ.thumb.700_0.jpeg", "测试1.jpg");
        TestThread2 t2 = new TestThread2("https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/6f061d950a7b0208d1ed7d8563d9f2d3572cc8aa.jpg", "测试2.jpg");
        TestThread2 t3 = new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180505%2Fdab71918ecff4797afec962d88985406.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620268164&t=a294065d113f9d2b3945c77eaf42ad56", "测试3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}


//下载器
class WebDownloader{

    //下载方法
    public void download(String url,String name) throws IOException {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，download方法出现异常");
        }
    }
}