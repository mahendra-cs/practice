package com.company.psds.array;

import java.util.Arrays;

public class NextBiggerNumber {
    public static void main(String[] args) {
        char[] arr = {'5','3','7','2','1'};
        System.out.println(getNextGreaterNumber(arr,arr.length));
    }
// 12345
    static int getNextGreaterNumber(char[] arr, int n){
        // start reading from last, try to find a digit which is greater than next
        int i;
        for (i=n-1; i>0; i--){
            if (arr[i] > arr[i-1]){
                break;
            }
        }

        if (i==0){
            return -1;
        }

        int x = arr[i-1];
        int min = i;

        for (int j=i+1; j<n ;j++){
            if (arr[j] > x && arr[j] < arr[min]){
                min = j;
            }
        }

        char tmp = arr[min];
        arr[min] = arr[i-1];
        arr[i-1] = tmp;

        Arrays.sort(arr, i, n);

        int result = 0;
        for (int k = 0; k<n; k++){
            result = result*10 + Character.getNumericValue(arr[k]);
        }

        return result;
    }
}
