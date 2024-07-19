package com.company.psds.random;

public class TaskGame {
    public static void main(String[] args) {
        getTasks(8);
    }

    public static void getTasks(int n){
        int level = 1;
        int i = 0;
        while (i < n){
            i = i + level;
            level += 1;
        }

        System.out.println(level -1);
        System.out.println(i - n);
    }
}
