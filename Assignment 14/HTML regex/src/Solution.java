import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberLine = scanner.nextInt();
        Pattern pattern = Pattern.compile("<a href="(\[\\w\d\/\\\:\?\&\=\.]+)".*>([\w\s]+)<\/a>");

        for (int i = 0; i < numberLine; i++) {
            
        }

        scanner.close();
    }
}

