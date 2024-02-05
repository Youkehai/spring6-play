package com.hs.ykh;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    private List<Test> test1 = new ArrayList<>();

    private List<Test> test2 = new ArrayList<>();


    public List<Test> getTest1() {
        return test1;
    }

    public void setTest1(Test test1) {
        this.test1.add(test1);
    }

    public List<Test> getTest2() {
        return test2;
    }

    public void setTest2(Test test2) {
        this.test2.add(test2);
    }
}
