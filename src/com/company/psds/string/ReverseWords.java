package com.company.psds.string;

public class ReverseWords {

    //Function to reverse words in a given string.
    public static void main(String[] args) {
        System.out.println(reverseWords("Function to reverse"));
    }
    static char[] reverseWords(String words){
        int start = 0;
        int n = words.toCharArray().length;
        char[] wordChars = words.toCharArray();
        for (int i=0; i<n; i++){
            if (words.charAt(i) == ' ') {
                reverseWord(wordChars, start, i - 1);
                start = i + 1;
            }
        }

        reverseWord(wordChars, start, n-1);

        reverseWord(wordChars, 0, n-1);

        return wordChars;
    }

    static void reverseWord(char[] word, int start, int end){
        while(start < end){
            char tmp = word[start];
            word[start] = word[end];
            word[end] = tmp;
            start++;
            end--;
        }
    }
}
