package com.hs.ykh;

public class TestReflect {

    private String name;

    private String desc;

    private int age;

    private void privateMethod(){
        System.out.println("我是类中的私有方法");
    }

    public TestReflect() {
    }

    public TestReflect(String name, String desc, int age) {
        this.name = name;
        this.desc = desc;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
