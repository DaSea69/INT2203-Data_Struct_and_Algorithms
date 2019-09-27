import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next, prev;
        Node(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    // add the item to the front
    private void addFirst(Item item) {
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
    private void addLast(Item item) {
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
    private Item removeFirst() {
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

    private Node front, back;
    private int n;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.front = null;
        this.back = null;
        this.n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return this.front == null;
    }

    // return the number of items on the randomized queue
    public int size() {
        return this.n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Null item");
        }
        if (StdRandom.uniform(2) == 0) {
            this.addFirst(item);
        }
        else {
            this.addLast(item);
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (this.front == null) {
            throw new NoSuchElementException();
        }
        return removeFirst();
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (this.front == null) {
            throw new NoSuchElementException();
        }
        Item item = this.removeFirst();
        this.addLast(item);
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node curFront = front;
            Node curBack = back;
            @Override
            public boolean hasNext() {
                return curBack != curFront.next;
            }
            @Override
            public Item next() {
                if (!this.hasNext()){
                        throw new NoSuchElementException();
                }
                Item item = null;
                if (StdRandom.uniform(2) == 0) {
                    item = curBack.item;
                    curBack = curBack.next; 
                }
                else {
                    item = curFront.item;
                    curFront = curFront.prev;
                }
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
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.enqueue(10);
        randomizedQueue.enqueue(20);
        randomizedQueue.enqueue(30);
        randomizedQueue.enqueue(40);
        randomizedQueue.enqueue(50);
        for(Integer x : randomizedQueue) {
            System.out.println(x);
        }
    }

}