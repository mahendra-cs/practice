package com.company.psds.array;

public class MaximizeOnes {

    // [1, 0, 1, 0, 0, 1]
    // m is maximum number of zeroes allowed to flip

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 0, 1, 1};
        findZeroes(arr, 7, 2);
    }
    static void findZeroes(int[] arr, int n, int m) {

        int wl = 0;
        int wr = 0;
        int bestL = 0;
        int bestWindow = 0;
        int zeroCount = 0;

        while (wr < n){
            if (zeroCount <= m){
                if (arr[wr] == 0)
                    zeroCount++;
                wr++;
            }

            if (zeroCount > m){
                if (arr[wl] == 0)
                    zeroCount--;
                wl++;

            }

            if (wr - wl > bestWindow && zeroCount <= m){
                bestWindow = wr - wl;
                bestL = wl;
            }
        }

        for (int i=bestL; i<bestWindow; i++) {
            if (arr[i] == 0)
                System.out.print(i + " ");
        }
    }



}
