package com.prvz.test_concurrency_robot.wait_notify;

public class Main {
    public static void main(String[] args) {
        Leg l1 = new Leg("left", 1000);
        Leg l2 = new Leg("right", 1000);
        Leg.LAST_LEG = l1;
        new Thread(l1).start();
        new Thread(l2).start();
    }
}
