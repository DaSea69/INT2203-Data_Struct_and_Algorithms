public class Kary{
    final static private String chr = "0123456789ABCDEF";
    public Kary() {
        
    }

    public static String convertToBase(int number, final int base) {
        if (base > 16 || base < 2) 
            throw new IllegalArgumentException();
        StringBuilder result = new StringBuilder("");
        while (number > 0) {
            result.append(chr.charAt(number % base));
            number /= base;
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(Kary.convertToBase(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}