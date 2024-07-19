package com.company.demo;

import java.util.function.*;

public class InterviewDemo {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(12);
//        list.add(13);
//        list.add(1);
//
//
//        List<Integer> listLessGreaterThen10 = list.stream().filter(x -> x>10)
//                .collect(Collectors.toList());

//        reverseWords("i.like.this.program.very.much");
        String name = "mahendra";
        System.out.println(reverseString(name));
        Function<Integer, Node> createList = size -> {
            Node node1 = new Node(1);
            Node tmp = node1;
            for (int i=2; i<=size; i++){
                Node node = new Node(i);
                tmp.next = node;
                tmp = node;
            }
            return node1;
        };
//
//
//
        Node node1 = createLinkedList(10);
        printLinkedList(node1);

        Node node = reverseALinkedList(node1, 3, 2, true);
        printLinkedList(node);

        int[] arr = { 1, 2, 3, 5 };
        int N = arr.length;

        // Function call
        System.out.println(getMissingNo(arr, N));

        System.out.println(isOdd().check(10));


    }

    public static PerformCalculation isOdd() {
      return n -> n % 2 != 0;
    }
    static int getMissingNo(int a[], int n)
    {
        int total = 1;
        for (int i = 2; i < (n + 1); i++) {
            total += i;
            total -= a[i - 2];
        }
        return total;
    }


    private static Node createLinkedList(int size) {
        Node node1 = new Node(1);
        Node tmp = node1;
        for (int i=2; i<=size; i++){
            Node node = new Node(i);
            tmp.next = node;
            tmp = node;
        }
        return node1;
    }

    private static void reverseWords(String S)
    {
        // code here
        String strArray[] = S.split("\\.");
        int len = strArray.length;
        int i=0;
        int j=len-1;
        while(i<j){
            String tmp = strArray[i];
            strArray[i] = strArray[j];
            strArray[j] = tmp;
            i++;
            j--;
        }
        StringBuilder output = new StringBuilder();
        output.append(strArray[0]);
        for (i=1; i<len; i++) {
            output.append(".").append(strArray[i]);
        }
        System.out.println(output);
    }

    private static void printLinkedList(Node node) {
        Node tmp;
        tmp = node;
        System.out.println();
        while (tmp != null){
            if (tmp.next == null) {
                System.out.print(tmp.data);
            } else {
                System.out.print(tmp.data + " -> ");
            }
            tmp = tmp.next;
        }
    }

    static String reverseString(String string){
        char[] chars = string.toCharArray();
        int length = chars.length;

        int i = 0;
        int j = length - 1;

        while (i<j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;

            i++;
            j--;
        }

        return new String(chars);
    }

//    private static String getString(char[] chars) {
//        int i;
//        String output = "";
//        for (i=0; i< chars.length; i++){
//            output = output + chars[i];
//        }
//        return output;
//    }

    private static void swap(char[] chars, int j, int i) {
        char tmp = chars[j];
        chars[j] = chars[i];
        chars[i] = tmp;
    }

// 1->2->3 ->4->5 ->6->7->8
// 3->2->1

    static Node reverseALinkedList(Node head, int k, int v, boolean flag){
        Node prev = null;
        Node curr = head;
        Node next = null;
        int k1;
        if (flag){
            k1 = k;
        } else {
            k1 = v;
        }
        while (curr != null && k1 > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k1--;
        }
        if (next != null){
            head.next = reverseALinkedList(next, k, v, !flag);
        }
        return prev;
    }

}
