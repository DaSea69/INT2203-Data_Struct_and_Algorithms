/** 
 * Ex 3.38
 * @author Nguyen Dinh Bien
 */

public class Exp {
    public static double getExp(final double x) {
        final double epsilon = 1e-8;
        double result = 1.0;
        double fact = 1.0;
        double sum = 1.0;
        int counter = 1;
        while (sum / fact > epsilon) {
            result += sum / fact;
            counter++;
            fact *= counter;
            sum *= x;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(getExp(Double.parseDouble(args[0])));
    }
}