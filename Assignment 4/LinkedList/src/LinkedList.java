/**
 * @author Nguyen Dinh Bien
 */
public class LinkedList {
    /**
     * @author Bien
     */
    private Node head;
    private Node tail;
    /**
     * @author Bien
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @return the head
     */
    public final Node getHead() {
        return head;
    }
    /**
     * @author Bien
     * @param value balala
     */
    public void addFirst(final int value) {
        this.head = new Node(value, this.head);
        if (head.getNext() == null) {
            this.tail = this.head;
        }
    }
    /**
     * @author Bien
     * @param value bala
     */
    public void addLast(final int value) {
        Node oldTail = this.tail;
        this.tail = new Node(value, null);
        if (oldTail == null) {
            this.head = this.tail;
        }
        else {
            oldTail.setNext(this.tail);
        }
    }
    /**
     * @author Bien
     */
    public void removeFirst() {
        if (head == null) {
            return; //throws something
        }
        head = head.getNext();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        final int ten = 10;
        linkedList.addFirst(ten);
        linkedList.addFirst(20);
        linkedList.addFirst(40);
        linkedList.addLast(30);

        for(Node node = linkedList.getHead(); node != null; node = node.getNext()) {
            System.out.println(node);
        }
    }
}
