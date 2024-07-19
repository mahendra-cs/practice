package com.company.java.threads;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {1, 3, 5, 10, 4, 23};
        printSecondLargest(arr, 6);

    }

    static void printSecondLargest(int[] arr, int n){

        int largest = 0;
        int secondLargest = 0;
        for (int i=0; i<n; i++){
            if (largest < arr[i]){
                secondLargest = largest;
                largest = arr[i];
            }
        }

        System.out.println(secondLargest);
    }

}
