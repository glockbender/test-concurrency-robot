package com.prvz.test_concurrency_robot.lock_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Leg implements Runnable {

    private final String name;
    private final Condition condition;
    private final Lock lock;
    private final long sleepInMillis;

    Leg(String name,
        Condition condition,
        Lock lock,
        long sleepInMillis) {
        this.name = name;
        this.lock = lock;
        this.condition = condition;
        this.sleepInMillis = sleepInMillis;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (true) {
                condition.signal();
                condition.await();
                System.out.println(name);
                Thread.sleep(sleepInMillis);
            }
        } catch (InterruptedException e) {
            System.err.println("INTERRUPTED. " + Thread.currentThread().toString());
        } finally {
            lock.unlock();
        }
    }

}
