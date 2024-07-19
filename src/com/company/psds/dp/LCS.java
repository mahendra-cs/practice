package com.company.psds.dp;

import java.util.*;

public class LCS {
    public static void main(String[] args) {
        System.out.println(getLCS("ABCDE", "ADE", 5, 3));
        //int[][] dp =
    }

    public static int getLCS(String string1, String string2, int n, int m){

        if (n == 0 || m == 0){
            return 0;
        }

        if (string1.charAt(n-1) == string2.charAt(m-1)){
            return 1 + getLCS(string1,string2,n-1,m-1);
        } else {
            return Math.max(getLCS(string1,string2,n,m-1), getLCS(string1,string2,n-1,m));
        }
    }

    public static int getLCSMemoized(String X, String Y, int n, int m, int[][] dp){

        if (n == 0 || m == 0){
            return 0;
        }

        if (dp[n][m] == -1){
            return 0;
        }

        if (X.charAt(n-1) == Y.charAt(m-1)){

        }

       // List<Integer> list = new ArrayList<>();
        //list.get()
        return 0;
    }


}
