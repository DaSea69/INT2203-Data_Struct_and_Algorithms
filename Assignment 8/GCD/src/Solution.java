import java.io.*;
import java.util.*;

public class Solution {

    public static int GCD(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();

        System.out.println(GCD(a, b));

        scanner.close();

    }
}

