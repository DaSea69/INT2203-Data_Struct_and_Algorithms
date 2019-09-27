public class Node {
    private int value;
    private Node next;

    public Node() {
        this(0, null);
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this(value, null);
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the next
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof Node) {
            Node tmp = (Node) obj;
            return this.value == tmp.value;
        } else {
            return false;
        }
    }
}
