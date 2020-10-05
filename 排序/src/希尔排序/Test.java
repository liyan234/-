package 希尔排序;


//近似于插入排序
//时间复杂度O(n^2)理论上达到最快O(N^1.3)
//空间复杂度O(1)
//稳定性：不稳定排序

import java.util.Arrays;

public class Test {

    public static void shellSort(int[] array) {
        //确定分组数，/2 /4 /8
        int gap = array.length / 2;
        while(gap > 1) {
            insertSortGap(array,gap);
            gap = gap/2;
        }
        insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {

        for(int bound = gap;bound < array.length; bound++) {

            int tmp = array[bound];
            int cur = bound - gap;

            for(;cur >= 0;cur = cur - gap) {

                if(array[cur] < tmp) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }

            array[cur + gap] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] array = {1,3,2,6,4,5,9,7,8,0};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

}
