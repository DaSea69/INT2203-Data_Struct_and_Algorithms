import java.util.Arrays;

/** 
 * Ex 3.35
 * @author Nguyen Dinh Bien
 */

 public class PrimeCounter {
    final static private int sizeMaxOfN = (int) 1e7; 
    static private boolean[] isPrime;
    static {
        isPrime = new boolean[sizeMaxOfN];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i < sizeMaxOfN; i++) {
            if (isPrime[i] == true) {
                for(int j = i * 2; j < sizeMaxOfN; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    } 
    public static void getListPrime(int n) {
        for(int i = 0; i < n; i++) {
            if (isPrime[i] == true) {
                System.out.printf("%d ", i);
            }
        }
    }

    public static void main(String[] args) {
        PrimeCounter.getListPrime(Integer.parseInt(args[0]));
    }
 }