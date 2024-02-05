package com.hs.ykh;

public class Test {

    private int age;

    private String name;

    private String desc;

    private String testNull;

    public Test(int age, String name, String desc, String testNull) {
        this.age = age;
        this.name = name;
        this.desc = desc;
        this.testNull = testNull;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public String getTestNull() {
        return testNull;
    }

    public void setTestNull(String testNull) {
        this.testNull = testNull;
    }
}