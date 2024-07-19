package com.company.java.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class OddEvenPrinter {
    static AtomicInteger count = new AtomicInteger(0);
    static int max = 10;

    public static void main(String[] args) {

        Object resource = new Object();

        Thread evenThread = new Thread(() -> {

            synchronized (resource){
                while (count.get() < max){
                    if (count.get() % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + " " +count);
                        count.incrementAndGet();
                        resource.notifyAll();
                    } else {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        } , "evenThread");

        Thread oddThread = new Thread(() -> {

            synchronized (resource){
                while (count.get() < max){
                    if (count.get() % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + " " +count);
                        count.incrementAndGet();
                        resource.notifyAll();
                    } else {
                        try {
                            resource.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        } , "oddThread");

        evenThread.start();
        oddThread.start();
    }























/*
    static AtomicInteger count = new AtomicInteger(0);
    static int max = 10;

    public static void main(String[] args) {
        Object obj = new Object();
        Thread oddThread = new Thread(() -> {
            synchronized (obj) {
                while (count.get() < max) {
                    if (count.get() % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " " + count);
                        count.incrementAndGet();
                        obj.notify();
                    } else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "oddThread");

       Thread evenThread = new Thread(() -> {
           synchronized (obj){
               while (count.get() < max){
                   if (count.get() % 2 == 0){
                       System.out.println(Thread.currentThread().getName() + " " +count);
                       count.incrementAndGet();
                       obj.notify();
                   } else {
                       try {
                           obj.wait();
                       } catch (InterruptedException e){
                           e.printStackTrace();
                       }
                   }
               }
           }
       }, "evenThread");

        oddThread.start();
        evenThread.start();
    }

*/
}
