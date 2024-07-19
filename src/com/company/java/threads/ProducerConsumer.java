package com.company.java.threads;


import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    static final Queue<Integer> queue = new LinkedList<>();
    int capacity;

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer(3);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    producerConsumer.produce(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i<10; i++) {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Bye!!");

    }

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait until there is space in the buffer
        }
        queue.add(value);
        System.out.println("Produced " + value);
        notifyAll(); // Notify consumers that data is available
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait until there is data in the buffer
        }
        int value = queue.poll();
        System.out.println("Consumed " + value);
        notifyAll(); // Notify producers that space is available
        return value;
    }
}
