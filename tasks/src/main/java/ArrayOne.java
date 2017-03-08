import java.util.Arrays;

/**
 * Class removes duplicates in the array (int[]).
 */
public class ArrayOne {
    private static int index = 0;

    /**
     * Method removes duplicates in the array (int[]).
     * @param arr array number int.
     * @return array int with out dublicate.
     */
    private int[] arrayDeleteDublicate(int[] arr) {
        int x = arr.length;
            for (int i = 0, j = 1; j < x; i++, j++) {
                if (arr[i] == arr[j]) {
                    int nextIndex = checked(j, arr);
                    index = index + (nextIndex - j);
                    x = x - index;
                    change(j, nextIndex, arr);
                }
                x++;
            }
            arr = Arrays.copyOf(arr, arr.length - index);
                for (int anArr : arr) {
                    System.out.println(anArr);
        }
        return arr;
    }

    /**
     * Method checks the sequence number matches.
     * @param n next number coinciding with previous.
     * @param arr array number int.
     * @return next index of element of array which not the same as the previous.
     */
    private int checked(int n, int[] arr) {
        int result = n + 1;
            for (int k = n + 1; k < arr.length; k++) {
                if (arr[k] != arr[n]) {
                    result = k;
                    break;
            }
        }
        return result;
    }

    /**
     * Method change elements in the array, transferring the duplicates to the end of the array.
     * @param a element which will replace next element.
     * @param b next element.
     * @param arr array number int.
     */
    private void change(int a, int b, int[] arr) {
        for (int i = a, j = b; j < arr.length; i++, j++) {
            arr[i] = arr[j];
        }
    }

    /**
     * Method main for start the program.
     * @param args array String arguments.
     */
    public static void main(String[] args) {
        ArrayOne arrayOne = new ArrayOne();
        int[] arr = new int[]{10, 11, 33, 5, 5, 5, 8, 2, 2, 7, 7, 9, 11, 12, 2, 2, 2, 3, 3, 3, 6};
        arrayOne.arrayDeleteDublicate(arr);
    }

}
























