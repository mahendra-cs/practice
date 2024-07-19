package com.company.psds.stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4,2,25};
        getNext(arr);
    }

    public static void getNext(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int n = arr.length;

        for (int i=1; i<n; i++){
            int next = arr[i];
            if (!stack.isEmpty()) {
                int element = stack.pop();
                while (element < next){
                    System.out.println(element+"-->"+next);
                    if (!stack.isEmpty()){
                        element = stack.pop();
                    } else {
                        break;
                    }
                }
                if (element > next){
                    stack.push(element);
                }
                stack.push(next);
            }
        }
    }
}
