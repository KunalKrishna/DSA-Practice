package tree_traversal;
public class Tree_Recursive_Traversal_v2 {

    static class Node
    {
        int data;
        Node left, right;
    
        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    
    static void inOrder (Node root) // a + b
    {
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    static void preOrder (Node root) // + a b
    {
        if(root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder (Node root) // b a + 
    {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) { 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("===RECURSIVE===");

        System.out.println("InOrder traversal");
        inOrder(root);
        System.out.println("PreOrder traversal");
        preOrder(root);
        System.out.println("PostOrder traversal");
        postOrder(root);
    }
}