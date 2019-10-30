import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        boolean isPali = true;
        for(int i = 0; i < A.length() / 2; i++) {
            if (A.charAt(i) != A.charAt(A.length() - i - 1)) {
                isPali = false;
                break;
            }
        }
        System.out.println(isPali ? "YES" : "NO");
        
        sc.close();
    }
}



