/**
 * BinaryTree
 */

class Node {
    final char value;
    final Node left;
    final Node right;

    public Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(char value) {
        this(value, null, null);
    }

}

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void preOderTraverse(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.value);
            preOderTraverse(node.left);
            preOderTraverse(node.right);
        }
    }

    public void preOderTraverse() {
        this.preOderTraverse(this.root);
    }

    public void postOderTraverse(Node node) {
        if (node == null) {
            return;
        } else {
            postOderTraverse(node.left);
            postOderTraverse(node.right);
            System.out.println(node.value);
        }
    }

    public void postOderTraverse() {
        this.postOderTraverse(this.root);
    }

    public void inOderTraverse(Node node) {
        if (node == null) {
            return;
        } else {
            inOderTraverse(node.left);
            System.out.println(node.value);
            inOderTraverse(node.right);
        }
    }

    public void inOderTraverse() {
        this.inOderTraverse(this.root);
    }

    public static void main(String[] args) {
        /*
         * A / \ B E / \ \ C D F
         */
        Node C = new Node('C', null, null);
        Node D = new Node('D', null, null);
        Node B = new Node('B', C, D);
        Node F = new Node('F', null, null);
        Node E = new Node('E', null, F);
        Node A = new Node('A', B, E);
        BinaryTree binaryTree = new BinaryTree(A);

        // binaryTree.preOderTraverse(binaryTree.root);
        // binaryTree.postOderTraverse();
        binaryTree.inOderTraverse();
    }
}