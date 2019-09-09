/**
 * Ex 3.28
 * @author Nguyen Dinh Bien
 */

public class GCD{
    /**
     * 
     * @param a first number
     * @param b sencond number
     * @return GCD of a and b
     * @throws argument error if a < 0 or b < 0
     */
    public static int getGCD(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException();
        }
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(GCD.getGCD(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}