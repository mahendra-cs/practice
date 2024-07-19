package com.company.psds.string;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("aabdc", "aabcd"));
        System.out.println(isAnagram("aabdca", "aaabcd"));

    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()){
            return false;
        }

        int[] chars = new int[256];

        for (char c: a.toCharArray()){
            chars[c]++;
        }

        for (char c: b.toCharArray()){
            chars[c]--;
        }

        for (int i : chars){
            if (chars[i] != 0){
                return false;
            }
        }
        return true;

    }
}
