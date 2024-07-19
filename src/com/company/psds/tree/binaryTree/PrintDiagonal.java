package com.company.psds.tree.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintDiagonal {

    ArrayList<Integer> print(Node root){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            if (p == null){
                queue.add(null);
                p = queue.poll();
                if (p == null)
                    break;
            }
            while (p != null) {
                System.out.print(p.data);
                list.add(p.data);
                if (p.left != null) {
                    queue.add(p.left);
                }
                p = p.right;
            }
        }
        return list;
    }
}
