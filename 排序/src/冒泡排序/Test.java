package 冒泡排序;

import java.util.Arrays;

//时间复杂度O(n^2)
//空间复杂度O(1)
//稳定排序
public class Test {

    public static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = array.length - 1; j > i; j--) {

                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 6, 4, 5, 9, 7, 8, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }


}
