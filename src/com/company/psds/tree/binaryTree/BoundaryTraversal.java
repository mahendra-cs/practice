package com.company.psds.tree.binaryTree;

import java.util.ArrayList;

public class BoundaryTraversal {
    public static void main(String[] args) {
        ArrayList<Integer> output = new ArrayList<>();
        Node node = new Node(1);
        output.add(node.data);
    }

    static void printBoundary(Node node){
        if (node == null){
            return;
        } else {
            System.out.println(node.data);
        }
        printBoundaryLeft(node);
        printLeaves(node.left);
        printLeaves(node.right);
        printBoundaryRight(node);
    }

    static void printBoundaryLeft(Node node){
        if (node == null)
            return;

        if (node.left != null){
            System.out.println(node.data);
            printBoundaryLeft(node.left);
        } else if (node.right != null){
            System.out.println(node.data);
            printBoundaryLeft(node.right);
        }
    }

    static void printBoundaryRight(Node node){
        if (node == null)
            return;

        if (node.right != null){
            printBoundaryRight(node.right);
            System.out.println(node.data);
        } else if (node.left != null){
            printBoundaryRight(node.left);
            System.out.println(node.data);
        }
    }

    static void printLeaves(Node node){
        if (node == null)
            return;

        printLeaves(node.left);
        if (node.left == null && node.right == null){
            System.out.println(node.data);
        }
        printBoundary(node.right);
    }



}
