import java.util.function.Consumer;

/**
 * RedBlackTree
 */
public class RedBlackTree {
    private enum Color {
        RED, BLACK;
    }

    private class Node {    
        char key;
        int value;
        Color color;
        Node right;
        Node left;

        public Node(char key, int value, Color color) {
            this.key = key;
            this.value = value;
            this.color = color;
        } 
        
        @Override
        public String toString() {
            return String.format("(%c - %d)", this.key, this.value);
        }
    }

    private Node root;

    private boolean isRedNode(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == Color.RED;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        x.color = y.color;
        y.color = Color.RED;
        
        return x;
    }

    private Node rotateLeft(Node x) {

        //      |
        //      x
        //   /    \
        //  a      y
        //       /  \
        //      b    c
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        y.color = x.color;
        x.color = Color.RED;

        return y;
    }

    private void flipColors(Node root) {
        root.color = Color.RED;
        root.left.color = Color.BLACK;
        root.right.color = Color.BLACK;
    }

    public void put(char key, int value) {
        this.root = put(key, value, this.root);
        this.root.color = Color.BLACK;
    }

    public Node put(char key, int value, Node root) {
        if (root == null) {
            return new Node(key, value, Color.RED);
        }

        if (key < root.key) {
            root.left = put(key, value, root.left);
        } else if (key > root.key) {
            root.right = put(key, value, root.right);
        } else {
            root.value = value;
        }

        if (!isRedNode(root.left) && isRedNode(root.right)) {
            root = rotateLeft(root);
        }
        if (isRedNode(root.left) && isRedNode(root.left.left)) {
            root = rotateRight(root);
        }
        if (isRedNode(root.left) && isRedNode(root.right)) {
            flipColors(root);
        }

        return root;
    }

    private void inOderTraversal(Node root, Consumer<Node> func) {
        if (root == null) {
            return ;
        } 
        inOderTraversal(root.left, func);
        func.accept(root);
        inOderTraversal(root.right, func);
    }

    public void inOderTraversal() {
        inOderTraversal(this.root, node -> System.out.println(node));
    }

    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        //      b
        //    a   c
        //          d
        redBlackTree.put('d', 12);
        redBlackTree.put('b', 10);
        redBlackTree.put('a', 2);
        redBlackTree.put('c', 11);

        redBlackTree.inOderTraversal();
    }
}
