import java.util.Arrays;
public class BubbleSort {

    public static void bubbleSort(int[] array) {

        for(int i = 0; i < array.length-1; i++) {

            for(int j = 0; j < array.length-1-i; j++) {

                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] array = {19,13,4,6,7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }
}
