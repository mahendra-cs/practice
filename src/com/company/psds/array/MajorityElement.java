package com.company.psds.array;

import java.util.Arrays;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,2);
        System.out.println(majorityElement(list));
    }
    public static int majorityElement(final List<Integer> A) {
        int n = A.size();
        int candidate = A.get(0);
        int occurance = 0;

        for (int i=1; i<n; i++){
            if (A.get(i) == candidate){
                occurance++;
            } else {
                occurance--;
                if (occurance == 0){
                    occurance = 1;
                    candidate = A.get(i);
                }

            }
        }
        int count = 0;
        for (int i=0; i<n; i++){

            if (A.get(i) == candidate){
                count++;
                if (count >= n/2){
                    return candidate;
                }
            }
        }

        return -1;

    }
}
