package com.company.psds.tree.binaryTree;

import java.util.*;

public class BottomView {
    static class Node{
        Node left;
        Node right;
        int hd;
        int value;
        public Node(int value) {
            this.left = null;
            this.right = null;
            this.hd = Integer.MAX_VALUE;
            this.value = value;
        }
    }
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
/*
        node1
        /  \
       /    \
    node2  node3
      /
     /
   node4
 */

        printBottomView(node1);
    }

    static void printBottomView(Node root){
        if (root == null){
            return;
        }
        Map<Integer, Node> treeMap = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        root.hd = 0;
        int hd;
        queue.add(root);

        while (!queue.isEmpty()){

            Node tmp = queue.poll();
            hd = tmp.hd;
            treeMap.put(hd, tmp);

            if (tmp.left != null) {
                tmp.left.hd = hd - 1;
                queue.add(tmp.left);
            }

            if (tmp.right != null) {
                tmp.right.hd = hd + 1;
                queue.add(tmp.right);
            }

        }
        treeMap.forEach((x, y) -> System.out.print(y.value+" "));

    }
}
