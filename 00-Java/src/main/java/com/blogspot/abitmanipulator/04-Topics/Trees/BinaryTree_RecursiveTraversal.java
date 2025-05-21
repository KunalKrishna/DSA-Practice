package com.blogspot.abitmanipulator;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree_RecursiveTraversal {
    public static void main(String[] args) {
        System.out.println("Recursive Traversal of Tree!");

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
        System.out.println(preorderTraversal(root));
        System.out.println(postorderTraversal(root));

    }

    // IN ORDER TRAVERSAL
    public static List<Integer> inorderTraversal(TreeNode root) {
        System.out.println("INORDER TRAVERSAL");
        List<Integer> result = new ArrayList<>();
        inorder(root, result); // Helper function to perform the recursive traversal
        return result;
    }
    private static void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return; // Base case: if the node is null, do nothing
        }
        inorder(node.left, result); // Recursively visit the left subtree
        result.add(node.val);            // Process the current node
        inorder(node.right, result); // Recursively visit the right subtree
    }

    // PRE ORDER TRAVERSAL
    public static List<Integer> preorderTraversal(TreeNode root) {
        System.out.println("PREORDER TRAVERSAL");
        List<Integer> result = new ArrayList<>();
        preorder(root, result); // Helper function to perform the recursive traversal
        return result;
    }
    private static void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return; // Base case: if the node is null, do nothing
        }
        result.add(node.val);        // Process the current node
        preorder(node.left, result); // Recursively visit the left subtree
        preorder(node.right, result); // Recursively visit the right subtree
    }

    // POST ORDER TRAVERSAL
    public static List<Integer> postorderTraversal(TreeNode root) {
        System.out.println("POST ORDER TRAVERSAL");
        List<Integer> result = new ArrayList<>();
        postorder(root, result); // Helper function to perform the recursive traversal
        return result;
    }
    private static void postorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return; // Base case: if the node is null, do nothing
        }
        postorder(node.right, result); // first, Recursively visit the right subtree
        postorder(node.left, result); // then, Recursively visit the left subtree
        result.add(node.val);        // finally, Process the current node
    }
}
