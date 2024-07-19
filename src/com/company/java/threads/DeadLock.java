package com.company.java.threads;

public class DeadLock {

    public static void main(String[] args) {
        String lock1 = "lock1";
        String lock2 = "lock2";

        Thread t1 = new Thread(() -> {
           synchronized (lock1){
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (lock2) {
                   System.out.println("taken lock. "+lock2);
               }
           }
        }, "thread1");

        Thread t2 = new Thread(() -> {
            synchronized (lock2){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("taken lock. "+lock1);
                }
            }
        }, "thread2");

        t1.start();
        t2.start();
    }

}
