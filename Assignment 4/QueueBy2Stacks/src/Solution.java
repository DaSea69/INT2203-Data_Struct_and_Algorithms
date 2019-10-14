import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Stack<Integer> stackInput = new Stack<Integer>();
        Stack<Integer> stackOutput = new Stack<Integer>();
        int numberOfQuery, operator;

        Scanner scanner = new Scanner(System.in);
        numberOfQuery = scanner.nextInt();
        for(int i = 0; i < numberOfQuery; i++) {
            operator = scanner.nextInt();
            switch (operator) {
                case 1 :
                    stackInput.push(scanner.nextInt());
                    break;
                case 2 : 
                    if (stackOutput.isEmpty()) {
                        while (!stackInput.isEmpty()) {
                            stackOutput.push(stackInput.pop());
                        }
                    }
                    stackOutput.pop();
                    break;
                case 3 : 
                if (stackOutput.isEmpty()) {
                    while (!stackInput.isEmpty()) {
                        stackOutput.push(stackInput.pop());
                    }
                }
                System.out.println(stackOutput.peek());
                    break;
            }
        }
        scanner.close();
    }
}

