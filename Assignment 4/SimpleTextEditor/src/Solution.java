import java.io.*;
import java.util.*;

abstract class Operator {

}
class Append extends Operator {
    int lengthAppend;
    public Append(int lengthAppend) {
        this.lengthAppend = lengthAppend;
    }
    public Append() {
        this(0);
    }
} 
class Delete extends Operator {
    String stringDeleted;
    public Delete(String stringDeleted) {
        this.stringDeleted= stringDeleted;
    }
}
public class Solution {
    public static void main(String[] args) {
        
        StringBuilder text = new StringBuilder();
        Stack<Operator> stateOfOperator = new Stack<Operator>();
        int numberOfOperator, operator, k;
        String textAppend;

        try {
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
            Scanner scanner = new Scanner(System.in);
            numberOfOperator = scanner.nextInt(); 
            for(int i = 0; i < numberOfOperator; i++) {
                operator = scanner.nextInt();
                switch (operator) {
                    case 1 : 
                        textAppend = scanner.next();
                        text.append(textAppend);
                        stateOfOperator.push(new Append(textAppend.length()));
                        //System.out.print(text);
                        break;
                    case 2 : 
                        k = scanner.nextInt();
                        stateOfOperator.push(new Delete(text.substring(text.length() - k)));
                        text.delete(text.length() - k, text.length());
                        //System.out.print(text);
                        break;
                    case 3 : 
                        k = scanner.nextInt();
                        //System.out.println(text.charAt(k - 1));
                        output.write(text.charAt(k - 1));
                        output.newLine();
                        break;
                    case 4 : 
                        if (stateOfOperator.peek() instanceof Append) {
                            Append append = (Append) stateOfOperator.pop();
                            text.delete(text.length() - append.lengthAppend, text.length());
                        }
                        else if (stateOfOperator.peek() instanceof Delete) {
                            Delete delete = (Delete) stateOfOperator.pop();
                            text.append(delete.stringDeleted);
                        }
    
                        //System.out.print(text);
                        break;
                    default : 
                        break;
                }
            }
            output.flush();
            output.close();
            scanner.close();

        }
        catch (Exception e) {

        }
        
    }
}

