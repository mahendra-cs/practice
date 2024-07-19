package com.company.psds.random;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(getFactorial(4));
    }

    public static int getFactorial(int number){
        if (number == 1)
            return 1;

        return number * getFactorial(number-1);
    }
}
