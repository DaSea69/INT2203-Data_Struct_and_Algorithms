
import java.util.*;

public class Solution {
    /**
     * Get N element to Stack. 
     * Each query follow by 
     * 1. Add an element to top of Stack
     * 2. Pop element at the top of Stack
     * 3. Get maximum value of stack (online) 
     * @param args
     */
    public static void main(String[] args) {
        Stack<Integer> stackValue = new  Stack<Integer>();
        Stack<Integer> stackPosition = new Stack<Integer>();
        int numberOfElement, numberOfQuery, query;
        Scanner scanner = new Scanner(System.in);
        
        numberOfQuery =  scanner.nextInt();

        stackValue.push(Integer.MIN_VALUE);
        stackPosition.push(-1);
        numberOfElement = 0;

        for(int i = 0; i < numberOfQuery; i++) {
            query = scanner.nextInt();
            switch (query) {
                case 1:
                    numberOfElement++;
                    int x = scanner.nextInt();
                    if (x >= stackValue.peek()) {
                        stackValue.push(x);
                        stackPosition.push(numberOfElement);
                    }
                    break;
                case 2 :
                    if (stackPosition.peek() == numberOfElement) {
                        stackPosition.pop();
                        stackValue.pop();
                    }
                    numberOfElement--;
                    break;
                case 3 :
                    System.out.println(stackValue.peek());
                    break;
                default:
                    break;
            }
        }

        scanner.close();
    }
}

