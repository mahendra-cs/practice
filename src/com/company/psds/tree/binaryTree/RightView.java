package com.company.psds.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        //Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        //node1.left = node2;
        node1.right = node3;
        //node2.left = node4;
        node3.left = node4;
        Node node5 = new Node(5);
        node4.left = node5;
        /*
        node1
        /  \
       /    \
    node2  node3
      /
     /
   node4

   ans. 1,3,4
 */
        rightSideView(node1);
        
    }

    static int maxLevel = -1;
    static List<Integer> output = new ArrayList<>();
    static List<Integer> rightSideView(Node root) {
        rightView(null, 0);
        return output;
    }

    public static void rightView(Node node, int level){
        if (node == null){
            return;
        }

        if (level > maxLevel){
            output.add(node.data);
            System.out.println(node.data);
            maxLevel = level;
        }
        rightView(node.right, level+1);
        rightView(node.left, level+1);
    }


}
