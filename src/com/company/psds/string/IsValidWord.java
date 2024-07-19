package com.company.psds.string;

public class IsValidWord {
    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        if (s.length() < 3)
            return false;

        int vowels = 0;
        int consonants = 0;
        for (char c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (!Character.isDigit(c)){
                return false;
            }
        }

        return vowels > 0 && consonants > 0;
    }
}
