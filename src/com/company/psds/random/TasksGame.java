package com.company.psds.random;

public class TasksGame {
    public static void main(String[] args) {
        getLevelAndTasks(5);
    }

    public static void getLevelAndTasks(int n){

        int level = findLevel(n);
        int totalTasks = (level*(level + 1)) / 2;
        System.out.println(level);
        System.out.println(totalTasks - n);

    }

    public static int findLevel(int k) {
        // Calculate the discriminant (1 + 8k)
        double discriminant = 1 + 8 * k;

        // Check if the discriminant is a perfect square and n is a whole number
        double sqrtDiscriminant = Math.sqrt(discriminant);

        // Check if the square root of the discriminant is an integer

            // Calculate n using the formula
            double n = (-1 + sqrtDiscriminant) / 2;

            // Return n if it is a positive integer
            if (n > 0) {
                return (int)Math.ceil(n);
            }


        // If there is no valid n, return -1
        return -1;
    }
}
