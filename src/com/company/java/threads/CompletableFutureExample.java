package com.company.java.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
           try {
               Thread.sleep(300);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
            return "completed";
        });

        try {
            String result = completableFuture.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Simulate fetching user details asynchronously
        CompletableFuture<String> userDetailsFuture = CompletableFuture.supplyAsync(() -> {
            // Simulate a time-consuming operation (e.g., fetching user details from a database)
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Return user details
            return "John Doe";
        }).thenApply(String::toUpperCase);

        // Apply transformation to the user details (convert to uppercase)
        //CompletableFuture<String> transformedUserDetailsFuture = userDetailsFuture.thenApply(String::toUpperCase);

        // Block and wait for the transformedUserDetailsFuture to complete
        String transformedUserDetails = null;
        try {
            transformedUserDetails = userDetailsFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Print the transformed user details
        System.out.println("Transformed user details: " + transformedUserDetails);

    }
}
