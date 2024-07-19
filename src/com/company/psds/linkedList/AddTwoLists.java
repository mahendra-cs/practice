package com.company.psds.linkedList;

public class AddTwoLists {
    public static void main(String[] args) {

        Node head1 = new Node(2);
        Node node1 = head1;
        Node head2 = new Node(3);
        Node node2 = head2;
        for (int i=0; i<1; i++){

            node1.next = new Node(i);
            node1 = node1.next;

            node2.next = new Node(i);
            node2 = node2.next;
        }

        printList(head1);
        printList(head2);
        Node head3 = addTwoLists(head1, head2);
        printList(head3);

    }

    public static void printList(Node node){
        while (node.next != null){
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println(node.data);
    }

    public static Node addTwoLists(Node first, Node second){
        int num1 = 0;
        int num2 = 0;
        while (first != null) {
            num1 = num1 * 10 + first.data;
            first = first.next;
        }

        while (second != null){
            num2 = num2 * 10 + second.data;
            second = second.next;
        }

        int num3 = num1 + num2;
        int last = num3 % 10;
        Node lastNode = new Node(last);
        num3 = num3 / 10;
        Node result = lastNode;

        while (num3 != 0) {
            int next = num3 % 10;
            Node nextNode = new Node(next);
            lastNode.next = nextNode;
            lastNode = nextNode;
            num3 = num3 / 10;
        }

        return reverse(result);
    }

    static Node reverse(Node head){
        Node current = head;
        Node prev = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static Node reverseInGroup(Node head, int k) {
        Node next = null;
        Node prev = null;
        Node current = head;
        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;

            if (next != null) {
                head.next = reverseInGroup(next, k);
            }
        }
            return prev;
    }

}
