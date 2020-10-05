package 堆排序;

//第一种方法
//升序排列，建立小堆，每次取堆定元素，放到一个额外的数组中，循环取n次
//空间复杂度O(n)


//第二种方法
//升序排列，建立一个大堆，每次取堆顶元素，和最后一个元素进行交换，再从堆顶位置开始往下调整，调整好堆结构。
//时间复杂度O(NLogN)
//空间复杂度O(1)
//不稳定排序

import java.util.Arrays;

public class Test {

    public static void sort(int[] array) {
        createHeap(array);
        int heapSize = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            swap(array,0,heapSize-1);
            heapSize--;
            //从根节点开始向下调整
            shiftDown(array,heapSize,0);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    private static void createHeap(int[] array) {

        for(int i = (array.length - 1 -1 ) / 2; i >= 0; i--) {
            //从最后一个非叶子节点向下调整，来建堆
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int length, int index) {
        int parent = index;
        int child = (parent * 2) + 1;

        while(child < length) {
            if((child + 1 < length) && array[child + 1] < array[child]) {
                child = child + 1;
            }
            if(array[child] < array[parent]) {
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = (parent * 2) - 1;

        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 6, 4, 5, 9, 7, 8, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
