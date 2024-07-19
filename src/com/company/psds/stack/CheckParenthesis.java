package com.company.psds.stack;

import java.util.Stack;

public class CheckParenthesis {
    public static void main(String[] args) {
        System.out.println(check("({[]})}"));
    }

    static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char pop = stack.pop();
            if (x == ')' && pop != '(')
                return false;
            if (x == '}' && pop != '{')
                return false;
            if (x == ']' && pop != '[')
                return false;
        }
        return stack.isEmpty();
    }
}
