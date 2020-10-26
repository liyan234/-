import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] array) {

        for(int i = 0;i < array.length;i++) {
            for(int j = 0;j < array.length - 1 - i;j++) {
                if(array[j] > array[j+1]) {
                    int tmp = 0;
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {4,6,2,3,8,1,6,7,9,5};
        System.out.println(Arrays.toString(array));
        System.out.println("排序后");
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
