package com.company.psds.string;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome1("0P"));
    }

    static boolean isPalindrome(String s){
        int n = s.length();
        int start = 0;
        int end = n-1;

        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        int i = 0;

        String trimmedString = sb.toString().toLowerCase();
        int j = trimmedString.length() - 1;
        while (i < j) {
            if (trimmedString.charAt(i) != trimmedString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }
}
