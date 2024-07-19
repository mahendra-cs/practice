package com.company.psds.array;

public class BuyAndSell {

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 6, 4 };
        int n = prices.length;
        System.out.println(maxProfit(prices, n));
    }
    static int maxProfit(int[] arr, int n){

        int buy = arr[0];
        int maxProfit = 0;

        for (int i=1; i<n; i++){
            if (buy > arr[i]) {
                buy = arr[i];
            } else if (maxProfit < arr[i] - buy){
                maxProfit = arr[i] - buy;
            }
        }

        return maxProfit;
    }
}
