package com.company.psds.sorting;

public class IngestionSort {
    public static void main(String[] args) {
        int arr[] = {1,2,5,3,6,8,9,7};
        sort(arr, arr.length);
        for (int i=0;i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void sort(int arr[], int n){
        for (int i=1; i< n; i++){
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
