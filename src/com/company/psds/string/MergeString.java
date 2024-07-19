package com.company.psds.string;

import java.util.HashMap;
import java.util.Map;

public class MergeString {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "xyz";
        System.out.println(merge(word1, word2));
        System.out.println(romanToInt("III"));
    }

    public static String merge(String word1, String word2){
        int i = 0;
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < word1.length() || j < word2.length()){
            if (i < word1.length()) {
                stringBuilder.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                stringBuilder.append(word2.charAt(j));
                j++;
            }
        }
        return stringBuilder.toString();
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int n = s.length();

        int total = map.get(s.charAt(0));
        for (int i=1; i<n; i++){
            if (map.get(s.charAt(i-1)) < map.get(s.charAt(i))){
                total = map.get(s.charAt(i)) - map.get(s.charAt(i-1));
            } else {
                total +=  map.get(s.charAt(i));
            }
        }

        return total;
    }
}
