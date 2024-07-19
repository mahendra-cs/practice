package com.company.java.threads;

public class NumberPrinter {

    int limit;
    private volatile int count = 1;
    public NumberPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd(){
        while (count < limit){
            if (count % 2 != 0){
                System.out.println(Thread.currentThread() + " "+count);
                count++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void printEven() {
        while (count < limit){
            if (count % 2 == 0){
                System.out.println(Thread.currentThread() + " " + count);
                count++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
