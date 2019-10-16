import java.util.Scanner;
import java.util.Stack;

/*
 queue : 1 2 3 4 5
 stack 1 : 2
 stack 2 : 1  
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stackIn = new Stack<Integer>();
        Stack<Integer> stackOut = new Stack<Integer>();
        int q, type, x;
        q = scanner.nextInt();
        for(int i = 0; i < q; i++) {
            type = scanner.nextInt();
            switch (type) {
                case 1 : 
                    x = scanner.nextInt();
                    break;
                case 2 : 
                    break;
                case 3 :
                    break;
                default : 
                    break;
            }
        }
        scanner.close();

    }
}