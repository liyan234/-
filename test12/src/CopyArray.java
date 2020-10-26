import java.util.Arrays;

public class CopyArray {

    public static int[] copyArray(int[] array) {
        int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        return array2;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        int[] ret = copyArray(array);
        System.out.println(Arrays.toString(ret));
    }
}


