package com.company.java.threads;

import java.util.ArrayList;
import java.util.List;

public class Workers {
    private static class Worker extends Thread{
        List<Integer> dataList;
        public Worker(List<Integer> dataList){
            this.dataList=dataList;
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                dataList.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> data = new ArrayList<>();
        Thread t1 = new Worker(data);
        Thread t2 = new Worker(data);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //Will you get data size of 200 ? yes
        System.out.println("Data size: "+data.size());
        System.out.println("Completed");
    }
}
