package com.blogspot.abitmanipulator;

public class TreeNode {
    int val;        // The value of the node
    TreeNode left;  // Reference to the left child
    TreeNode right; // Reference to the right child
    /*
     * In Java, if a field in a class is not explicitly marked public, it is assigned package-private access by default,
     * which means it can only be accessed by other classes in the same package.
     * To fix this issue and allow direct access to 'left' and 'right' (or any other field), you need to declare them as public.
     * However, directly exposing fields is not always considered good practice.
     * A better approach would be to keep them private and provide getter and setter methods for controlled access.
     * */

    // constructor to initialize a node with a value
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    // overload constructor to initialize a node with a value and children
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
