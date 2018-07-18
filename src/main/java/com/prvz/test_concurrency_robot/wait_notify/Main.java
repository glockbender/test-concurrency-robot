package com.prvz.test_concurrency_robot.wait_notify;

public class Main {

    public static void main(String[] args) {
        Leg l1 = new Leg("left", 1000);
        Leg l2 = new Leg("right", 1000);
        Leg.LAST_LEG = l1;
        Thread t1 = new Thread(l1);
        Thread t2 = new Thread(l2);
        t1.start();
        t2.start();
        try {
            Thread.sleep(5000L);
            t1.interrupt();
            t2.interrupt();
        } catch (InterruptedException e) {
            System.err.println("MAIN THREAD INTERRUPT");
            e.printStackTrace();
        }
    }
}
