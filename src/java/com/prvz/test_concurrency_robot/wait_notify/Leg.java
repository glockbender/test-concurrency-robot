package com.prvz.test_concurrency_robot.wait_notify;

public class Leg implements Runnable {
    private static final Object monitor = new Object();
    static volatile Leg LAST_LEG;
    private final String name;
    private final long sleepInMillis;

    Leg(String name,
        long sleepInMillis) {
        this.name = name;
        this.sleepInMillis = sleepInMillis;
    }

    public void run() {
        try {
            while (true) {
                synchronized (monitor) {
                    monitor.notifyAll();
                    while (LAST_LEG == this) monitor.wait();
                    LAST_LEG = this;
                    System.out.println(name);
                    Thread.sleep(sleepInMillis);
                }
            }
        } catch (InterruptedException e) {
            System.err.println("INTERRUPTED. " + Thread.currentThread().toString());
        }
    }
}
