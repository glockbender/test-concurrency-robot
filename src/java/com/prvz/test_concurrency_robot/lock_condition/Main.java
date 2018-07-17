package com.prvz.test_concurrency_robot.lock_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Condition monitor = lock.newCondition();
        new Thread(new Leg("left", monitor, lock, 1000)).start();
        new Thread(new Leg("right", monitor, lock, 1000)).start();
    }
}
