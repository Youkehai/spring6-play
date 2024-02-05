package com.hs.ykh.containter;

public class SmallClass {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SmallClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
