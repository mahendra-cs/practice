package com.company.psds.array;

import java.util.Arrays;

public class ZerosAtASide {
    public static void main(String[] args) {
        int[] arr = {5,0,3,0,0,1};
        int n = arr.length;
        zerosAside(arr, n);

    }

    public static void zerosAside(int[] arr, int n){

        int count = 0;

        for (int i=0; i<n; i++){
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }

        for (int i=count; i<n; i++){
            arr[i] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int[] arr, int n)
    {
        for (int i=1; i<n; i+=2){


                if (i > 0 && arr[i] > arr[i-1]){
                    // swap
                    int tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;

                }

                if (i < n-1 && arr[i] < arr[i+1]) {
                    // swap
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }

        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
