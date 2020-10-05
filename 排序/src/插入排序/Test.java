package 插入排序;


//时间复杂度O(n^2)
//空间复杂度O(1)
//稳定性：稳定性排序
//元素个数较少的时候排序效率比较高
//元素如果已接近有序，排序效率也比较高

import java.util.Arrays;

public class Test {
    public static void insertSort(int[] array){

        for (int i = 1; i < array.length; i++) {

            int tmp = array[i];
            int cur = i - 1;
            for(;cur >= 0; cur--) {

                if(array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,2,6,4,5,9,7,8,0};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

}
