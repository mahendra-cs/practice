package com.company.psds.array;

import java.util.Arrays;
// re-arrange in positive negative form
public class RearrangeNumbers {
    public static void main(String[] args) {
        int[] arr = {-2,-1,2,4,8,5,7,-5};
        reArrange(arr);
    }

    static void reArrange(int[] arr){
        int i = -1;
        int n = arr.length;

        for (int j=0; j<n; j++){
            if (arr[j] < 0){
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }


        }

        int pos = i+1;
        int neg = 0;

        while (pos < n && neg < pos && arr[neg] < 0){
            int tmp = arr[pos];
            arr[pos] = arr[neg];
            arr[neg] = tmp;
            neg += 2;
            pos++;
        }

        System.out.println(Arrays.toString(arr));
    }
}
