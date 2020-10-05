package 选择排序;


//时间复杂度 O(n^2)
//空间复杂度 O(1)
//稳定性 ：不稳定排序

import java.util.Arrays;

public class Test {

    public static void sort (int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = i; j < array.length ; j++) {

                if(array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;

                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 6, 4, 5, 9, 7, 8, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
