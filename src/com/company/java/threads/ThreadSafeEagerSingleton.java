package com.company.java.threads;

public class ThreadSafeEagerSingleton {

    private ThreadSafeEagerSingleton() {

    }

    public static ThreadSafeEagerSingleton getInstance(){
        return EagerSingletonHelper.instance;
    }

    private static class EagerSingletonHelper {
        private static final ThreadSafeEagerSingleton instance = new ThreadSafeEagerSingleton();
    }
}
