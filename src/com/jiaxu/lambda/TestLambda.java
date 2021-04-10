package com.jiaxu.lambda;

public class TestLambda {
    //静态内部类
    static class Like2 implements iLove {

        @Override
        public void love() {
            System.out.println("我喜欢1");
        }
    }

    public static void main(String[] args) {

        //局部内部类
        class Like3 implements iLove {

            @Override
            public void love() {
                System.out.println("我喜欢2");
            }
        }


        iLove like = new Like();
        like.love();
        like = new Like2();
        like.love();
        like = new Like3();
        like.love();

        //匿名内部类：没有类的名称，必须借助接口或者父类
        like = new iLove() {
            @Override
            public void love() {
                System.out.println("我喜欢333");
            }
        };

        like = ()-> System.out.println("我喜欢22");

        //总结：
        //lambda表达式只能在一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块包裹
        //前提接口是函数式接口，就是接口里只有一个函数
        //多个函数也可以去掉参数类型，要去掉就都去掉，必须加上括号
    }
}

interface iLove {
    void love();
}

//首先可以是内部类
class Like implements iLove {

    @Override
    public void love() {
        System.out.println("我喜欢");
    }
}