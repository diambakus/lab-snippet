class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class BinaryTree {

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void printInOrder(Node node) {
        
        if (node == null)
            return;
        
        //Visit left subtree
        printInOrder(node.left);
        System.out.printf("%d ", node.value);
        //Visit left subtree
        printInOrder(node.right);
    }

    void printInOrder() {printInOrder(root);}
}

public class BinarySearchTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);

        binaryTree.root.left = new Node(2); 
        binaryTree.root.right = new Node(3); 
        binaryTree.root.left.left = new Node(4); 
        binaryTree.root.left.right = new Node(5); 

        System.out.printf("%n Print InOrder() %n");
        binaryTree.printInOrder();
    }

}