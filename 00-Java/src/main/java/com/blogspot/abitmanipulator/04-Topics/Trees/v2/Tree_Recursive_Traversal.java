package tree_traversal;
class Node
{
    int data;
    Node left, right;
 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class Tree_Recursive_Traversal {
    
    Node root ; 
    public void inOrder(Node root) // a + b
    {
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public void preOrder (Node root) // + a b
    {
        if(root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder (Node root) // b a + 
    {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) { 
        Tree_Recursive_Traversal tree = new Tree_Recursive_Traversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("===RECURSIVE===");
        System.out.println("InOrder traversal");
        tree.inOrder(tree.root);
        System.out.println("PreOrder traversal");
        tree.preOrder(tree.root);
        System.out.println("PostOrder traversal");
        tree.postOrder(tree.root);
    }
}