package com.company.java.threads;

public class ThreadTutorials {

    public static void main(String[] args) {

      for (int j=0; j<5; j++) {
//          Thread thread = new Thread(() -> {
//              for (int i = 0; i < 5; i++) {
//                  System.out.println("Thread :" + "running loop "+ i);
//              }
//          });

          DemoThread demoThread = new DemoThread("Thread : "+j);
          Thread thread = new Thread(demoThread);
          thread.start();
          try {
              thread.wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

      }

    }
}
