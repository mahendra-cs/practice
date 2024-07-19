package com.company.java.threads.executerService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<String> urls = new ArrayList<>();

        urls.add("url1");
        urls.add("url2");
        urls.add("url3");
        urls.add("url4");

        List<Future<String>> futureResults = new ArrayList<>();
        urls.forEach(url -> {
            Future<String> future = executorService.submit(() -> getResponse(url));
            futureResults.add(future);
        });

        futureResults.forEach(result  -> {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();
    }

    static String getResponse(String url) {
        try {
            System.out.println("Calling service");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "response: "+url;
    }
}





























//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        Runnable runnable1 = () -> {
//            System.out.println("inside runnable1");
//        };
//        Runnable runnable2 = () -> {
//            System.out.println("inside runnable2");
//        };
//
//        Callable<String> callable = () -> {
//            System.out.println("inside callable1");
//            return "callable1";
//        };
//
//        executorService.execute(runnable1);
//        executorService.execute(runnable2);
//        Future<String> future = executorService.submit(callable);
//        System.out.println(future.get());
//        executorService.awaitTermination(300, TimeUnit.SECONDS);
//    }
//
//    public static void printUrls(){
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        List<String> urls = new ArrayList<>();
//        urls.add("url1");
//        urls.add("url2");
//        urls.add("url3");
//        urls.add("url4");
//
//        List<Future<String>> results = new ArrayList<>();
//
//
//        for (String url : urls) {
//            results.add(executorService.submit(() -> getDataFromUrls(url)));
//        }
//
//        results.stream().map(result -> {
//            try {
//                return result.get();
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//                return null;
//            }
//
//        }).collect(Collectors.toList()).forEach(System.out::println);
//
//        executorService.shutdown();
//    }
//
//    static String getDataFromUrls(String url) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "response " + url;
//    }

