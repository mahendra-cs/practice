package com.company.java.threads;

public class DemoThread implements Runnable{

    String threadName;
    public DemoThread(String threadName) {
        this.threadName = threadName;
    }

    public void run () {
        for (int i=0; i<5; i++){
            System.out.println("Running " + threadName + " loop " + i);
        }
    }
}
