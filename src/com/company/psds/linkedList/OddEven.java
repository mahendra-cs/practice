package com.company.psds.linkedList;

public class OddEven {
    Node OddAndEven(Node head){
        // base cases when there is 1 or 2 nodes
        if (head == null)
            return null;
        if (head.next == null && head.next.next == null)
            return head;
        Node oddHead = head;
        Node evenHead = head.next;
        Node oddP = head;
        Node evenP = head.next;

        while (evenP != null && evenP.next != null){
            oddP.next = oddP.next.next;
            evenP.next = evenP.next.next;
            oddP = oddP.next;
            evenP = evenP.next;
        }
        oddP.next = evenHead;
        return oddHead;
    }
}
