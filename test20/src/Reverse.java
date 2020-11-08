import java.util.Arrays;

public class Reverse {

    public static void reverse(int[] array) {
        /*for(int i = 0; i < array.length/2 ; i++) {
            int temp = array[i];
            array[i] = array[array.length -1 -i];
            array[array.length-1-i] = temp;
        }*/

        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[left] = tmp;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {

        int[] array = {19,13,4,6,7};
        reverse(array);
        System.out.println(Arrays.toString(array));

    }
}
