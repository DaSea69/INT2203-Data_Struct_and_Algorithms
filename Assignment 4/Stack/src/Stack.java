public class Stack {
    public static void main(String[] args) {
        StackByArrays stack = new StackByArrays();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        stack.push(30);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}