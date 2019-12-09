import java.util.function.Consumer;

/**
 * BinarySearchTree
 */
public class BinarySearchTree {

    private class Node {
        private char key;
        private Integer value;
        private Node left;
        private Node right;

        public Node(char key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
        
    }

    private Node root;

    public Integer get(char key) {
        return get(this.root, key);
    }

    private Integer get(Node root, char key) {
        if (root == null) {
            return null;
        } else if (key == root.key) {
            return root.value;
        } else if (key < root.key) {
            return get(root.left, key);
        } else {
            return get(root.right, key);
        }
    }

    public void put(char key, int value) {
        root = put(root, key, value);
    }

    private Node put(Node root, char key, int value) {
        if (root == null) {
            return new Node(key, value);
        } else if (key < root.key) {
            root.left = put(root.left, key, value);
        } else if (key == root.key) {
            root.value = value;
        } else {
            root.right = put(root.right, key, value);
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

    public void inOderTraversal(Consumer<Node> func) {
        inOderTraversal(this.root, func);
    }

    private Node delMinNode(Node root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = delMinNode(root.left);
        return root;
    }

    private Node min(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return min(root.left);
        }
    }

    public void delete(char key) {
        root = delete(root, key);
    }

    public Node delete(Node root, char key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            //subtree has 1 child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            Node t = root;
            root = min(t.right);
            root.right = delMinNode(t.right);
            root.left = t.left;
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        //      b
        //    a   c
        //          d

        binarySearchTree.put('b', 10);
        binarySearchTree.put('a', 2);
        binarySearchTree.put('c', 12);
        binarySearchTree.put('d', 15);

        System.out.println(binarySearchTree.get('a'));

        System.out.println("Before delete");

        binarySearchTree.inOderTraversal();


        System.out.println("After delete");        
        binarySearchTree.delete('b');

        binarySearchTree.inOderTraversal();
    }
}
