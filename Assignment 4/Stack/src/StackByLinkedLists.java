class StackByLinkedLists {
    private class Node {
        int data;
        Node next;
        
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private int n;
    private Node first;

    public StackByLinkedLists() {
        n = 0;
        first = null;
    }

    public void push(int Item) {
        first = new Node(Item, first);
        n++;
    }

    public int pop() {
        int value = first.data;
        first = first.next;
        n--;
        return value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        StackByLinkedLists stack = new StackByLinkedLists();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    } 
}