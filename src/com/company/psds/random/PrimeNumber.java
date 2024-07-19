package com.company.psds.random;

public class PrimeNumber {
    public static void main(String[] args) {
        // write your code here
        getPrime(1000,1100);
        System.out.println();
        for (int i=1000; i<1100; i++){
            if (isPrime(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    // input 1000

    static void getPrime(int lower, int upper) {
        boolean flag = true;
        for (int j = lower; j < upper; j++) {
            for (int i = 2; i < j; i++) {
                if (j % i != 0){
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(j+", ");
            }
            flag = true;
        }
    }

    static boolean isPrime(int n){
        if (n==1||n==0)
            return false;
        for (int i=2; i<n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
