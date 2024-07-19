package com.company.psds.dp;

import java.util.Arrays;

public class KnapSack {

    public static void main(String[] args) {
        int v[] = new int[] { 60, 100, 120 };
        int w[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = v.length;
        System.out.println(getMaxValue(w, v, n, W));
        int[][] dp = new int[n+1][W+1];

        for (int[] row: dp){
            Arrays.fill(row, -1);
        }
        System.out.println(getMaxValueMemoize(w, v, n, W, dp));

    }

    // Recursive solution
   static int getMaxValue(int[] w, int[] v, int n, int W){
        if (n == 0 || W == 0){
            return 0;
        }

        if (w[n-1] > W){
            return getMaxValue(w, v, n-1, W);
        } else {
            return Math.max(v[n-1] + getMaxValue(w, v, n-1, W - w[n-1]), getMaxValue(w,v,n-1,W));
        }

   }

   // Memoization

    static int getMaxValueMemoize(int[] w, int[] v, int n, int W, int[][] dp){
        if (n == 0 || W == 0){
            return 0;
        }

        if (dp[n][W] != -1){
            return dp[n][W];
        }

        if (w[n-1] > W){
            return dp[n][W] = getMaxValue(w, v, n-1, W);
        } else {
            return dp[n][W] = Math.max(v[n-1] + getMaxValue(w, v, n-1, W - w[n-1]), getMaxValue(w, v, n-1, W));
        }
    }


}
