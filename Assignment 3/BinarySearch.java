/**
 * @author Nguyen Dinh Bien
 */
public class BinarySearch {
    public static int binarySearch(int[] list, int number) {
        /*
            |----------|---------|
            l          mid       r

        */
        int l, r;
        int index = -1;
        l = 0;
        r = list.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list[mid] == number) {
                index = mid;
                break;
            }
            else if (list[mid] > number) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8 ,9};
        System.out.println(BinarySearch.binarySearch(list, 8));
    }
}