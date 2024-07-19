package com.company.java.string;

import com.company.java.threads.CompletableFutureExample;

import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = new String("Hello");
        String str3 = "Hello";
        if (str1.equals(str2)){
            System.out.println("==");
        }

    }
}
