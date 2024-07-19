package com.company.java.threads;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {

    }

    public static ThreadSafeSingleton getInstance(){
        if (instance == null){
            synchronized (ThreadSafeSingleton.class){
                while (instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}











//private static volatile ThreadSafeSingleton instance;
//private ThreadSafeSingleton() {
//
//}
//
//public static void main(String[] args) {
//    ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
//}
//
//public static ThreadSafeSingleton getInstance(){
//    if(instance == null) {
//        synchronized (ThreadSafeSingleton.class){
//            if (instance == null){
//                instance = new ThreadSafeSingleton();
//            }
//        }
//    }
//    return instance;
//}