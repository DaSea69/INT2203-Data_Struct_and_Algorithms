public class Queue<Item> {
    private class Node {
        Item data;
        Node next;
        Node(Item data, Node next) {
            this.data = data;
            this.next = next;
        }
        Node(Item data) {
            this(data, null);
        }
    }

    private Node last, first;
    private int n;
    public Queue() {
        last = null;
        first = null;
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldLast = this.last;
        this.last = new Node(item);
        if (first == null) {
            first = this.last;
        }
        else {
            oldLast.next = this.last;
        }
        n++;
    }

    public Item dequeue() {
        Item value = first.data;
        this.first = first.next;
        n--;
        return value;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}