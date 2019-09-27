import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next, prev;
        Node(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }
    private Node front, back;
    private int n;
    // construct an empty deque
    public Deque() {
        this.front = null;
        this.back = null;
        this.n = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return this.front == null;
    }

    // return the number of items on the deque
    public int size() {
        return this.n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null item");
        }
        if (this.front == null) {
            this.front = new Node(item);
            this.back = this.front;
        }
        else {
            Node oldFront = this.front;
            this.front = new Node(item);
            oldFront.next = this.front;
            this.front.prev = oldFront;
        }
        n++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null item");
        }
        if (this.back == null) {
            this.back = new Node(item);
            this.front = this.back;
        }
        else {
            Node oldBack = this.back;
            this.back = new Node(item);
            oldBack.prev = this.back;
            this.back.next = oldBack;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.front == null) {
            throw new NoSuchElementException();
        }
        Item item = this.front.item;
        if (this.front.prev == null) {
            this.front = null;
            this.back = null;
        }
        else {
            this.front.prev.next = null;
            this.front = this.front.prev;
        }
        n--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (this.front == null) {
            throw new NoSuchElementException();
        }
        Item item = this.back.item;
        if (this.back.next == null) {
            this.back = null;
            this.front = null;
        }
        else {
            this.back.next.prev = null;
            this.back = this.back.next;
        }
        n--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node curNode = front;
            @Override
            public boolean hasNext() {
                return curNode != null;
            }
            @Override
            public Item next() {
                if (curNode == null) {
                        throw new NoSuchElementException();
                }
                Item item = curNode.item;
                curNode = curNode.prev;
                return item;
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);
        deque.addFirst(40);
        for(Integer x : deque) {
            System.out.println(x);
        }
        // Iterator iterator = deque.iterator();
        // while (iterator.hasNext()) {
        //     System.out.println(iterator.next());
        // }
    }

}