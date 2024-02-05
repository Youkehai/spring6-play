package com.hs.ykh;


public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        ListTest listTest = new ListTest();
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                listTest.setTest1(new Test(i, "namenamenamemandsamdsad", "descdescdescdescdescdescdescdesc", "123"));
            }
            else if (i % 5 == 0) {
                listTest.setTest2(new Test(i, "s", "d", "s"));
            }
        }
        Thread.sleep(1000 * 200);
    }
}
