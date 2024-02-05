package com.hs.ykh.life;

public class LifeCycle {

    private String name;


    public String getName() {
        return name;
    }

    //第三步，调用后置处理器，在调用初始化方法之前
    public void init(){
        System.out.println("第四步：调用了指定的初始化方法");
    }
    //第五步，调用后置处理器，处理初始化之后的类
    //第六步，对象创建完成，可以使用
    public void myMethod(){
        System.out.println("第六步，对象创建完成，并调用了自己的方法");
    }
    public void destroy(){
        System.out.println("第七步：调用了指定的销毁方法");
    }

    public void setName(String name) {
        System.out.println("第二步：调用了set方法设置属性值");
        this.name = name;
    }


    public LifeCycle() {
        System.out.println("第一步：使用了无参构造器");
    }
}
