package com.company.psds.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,9,9,12};
        //search(arr, arr.length, 90);
        //System.out.println(getClosestNumber(arr, arr.length, 1));
        System.out.println(Arrays.toString(twoSum(arr, 10)));
    }

    // 2,4,6,9,10
    // x = 9

    static void search(int[] arr, int n, int x) {
        int l = 0;
        int r = n-1;
        boolean flag = true;
        while (l <= r){
            int m = (l+r)/2;
            if (arr[m] == x) {
                System.out.println("found at " + m);
                flag = false;
            }

            if (x > arr[m])
                l = m+1;
            else
                r = m-1;
        }
        if (flag)
            System.out.println("not found");
    }

    /*
    Consider a sorted array of positive integers:
    a=[3,4,6,9,10,12,14,15,17,19,21]
    Define a function f(a,x) that returns the element of array a closest to x but smaller than or equal to x, or returns -1 if no such element exists.
    For example:
    f(a,12)=12
    f(a,13)=12
    */

    static int getClosestNumber(int[] arr, int n, int x) {
        int l = 0;
        int r = n-1;
        int closestElement = -1;
        while (l <= r) {
            int m = (l+r)/2;
            if (x == arr[m])
                return x;

            if (x >= arr[m]) {
                closestElement = arr[m];
                l = m + 1;
            }
            else
                r = m-1;
        }

        return closestElement;
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
