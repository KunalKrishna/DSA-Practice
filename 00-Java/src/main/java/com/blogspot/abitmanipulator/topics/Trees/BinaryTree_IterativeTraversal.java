package com.blogspot.abitmanipulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree_IterativeTraversal {
    public static void main(String[] args) {
        System.out.println("Iterative Traversal of Binary Tree !!!");

        // Create nodes
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Now the tree looks like this:
        //        1
        //      /   \
        //     2     3
        //    / \   / \
        //   4   5 6   7
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Visit the node
            current = stack.pop();
            result.add(current.val);
            // Move to the right subtree
            current = current.right;
        }
        return result;
    }
}

