package com.company.psds.array;

/*
Given an array of elements of length N, ranging from 0 to N – 1. All elements may not be present in the array.
If the element is not present then there will be -1 present in the array.
Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.

Examples:
Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
*/

import java.util.Arrays;

public class ReArrangeArray {
    public static void main(String[] args) {
        int[] arr = {-1, -1, 6, 1, 9, 2, 3, -1, 4, -1};
        System.out.println(Arrays.toString(arr));

        for (int i=0; i<arr.length; i++){
            if (arr[i] != -1 && arr[i] != i) {
                int x = arr[i];
                while (arr[x] != x && arr[x] != -1) {
                    int y = arr[x];
                    arr[x] = x;
                    x = y;
                }
                arr[x] = x;
                if (arr[i] != i){
                    arr[i] = -1;
                }
            }

        }

        System.out.println(Arrays.toString(arr));
    }
}
