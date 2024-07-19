package com.company.java.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    static void produce(int i){

    }

    static void consume() {

    }
}
