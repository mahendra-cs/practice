package com.company.psds.sorting;

import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {1, 2, 7, 4, 3, 9};
        int n = arr.length;
        sort(arr, n);
        print(arr, n);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
    }

    private static void print(int[] arr, int n) {
        for (int i = 0; i< n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    static void sort(int[] arr, int n){
        //build heap
        for (int i = n/2 -1; i >= 0; i--){
            heapify(arr, n, i);
        }

        //swap last item with first then call heapify on reduced arr
        for (int i= n-1; i > 0; i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest]){
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]){
            largest = r;
        }

        if (largest != i){
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, n, largest);
        }
    }
}
