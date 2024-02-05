package com.hs.ykh;

/**
 * 使用xml注入属性值
 */
public class CustomIOCSet {

    private String name;

    private String desc;

    private String testNull;

    public String getTestNull() {
        return testNull;
    }

    public void setTestNull(String testNull) {
        this.testNull = testNull;
    }

    public String getName() {
        return name;
    }

    public CustomIOCSet() {
    }

    public CustomIOCSet(String name, String desc) {
        this.name = name;
        this.desc = desc;
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

    @Override
    public String toString() {
        return "CustomIOCSet{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", testNull='" + testNull + '\'' +
                '}';
    }
}
