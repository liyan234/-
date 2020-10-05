package 归并排序;


//时间复杂度 O(NLogN)
//空间复杂度 O(N + LogN) = O(N)
//稳定排序


//归并排序可以高效对链表进行排序
//数组可以进行随机访问，链表只能取next，堆排序，快速排序，希尔排序无法高效运用到链表上

//归并排序可以高效的进行“外部排序”，是一种“外部排序”的主要实现方法
//外部排序：数据在磁盘上（外存中），数据量非常大，无法全部加载到内存中。

import java.util.Arrays;

public class Test {

    //递归算法
    public static void sort(int[] array) {

        sortHelp(array,0,array.length);

    }

    private static void sortHelp(int[] array, int left, int right) {

        //这个分组中只有一个或者没有值了
        if(right - left <= 1 ){
            return;
        }

        int mid = (left + right) / 2;

        sortHelp(array,left,mid);
        sortHelp(array,mid,right);

        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //两个有序数组[left,mid)   [mid,right)
        int x = left;
        int y = mid;

        //创建一个零时数组，然后两两比较大小
        int[] out = new int[right - left];
        int index = 0;
        //一个从x开始，一个从y开始
        while (x < mid && y < right) {

            //这里必须是 <= 归并排序才会成为稳定性排序
            if(array[x] <= array[y]) {
                out[index] = array[x];
                x++;
                index++;
            } else {
                out[index] = array[y];
                y++;
                index++;
            }
        }

        while(x < mid) {
            out[index] = array[x];
            x++;
            index++;
        }
        while (y < right) {
            out[index] = array[y];
            y++;
            index++;
        }
        //将数据拷贝回来
        for (int i = 0; i < right - left ; i++) {
            array[left + i] = out[i];
        }
    }




    //非递归算法

    public static void sortByLoop(int[] array) {

        //分组
        for (int gap = 1; gap < array.length; gap = gap * 2) {

            //按顺序两组比较大小后一并
            for (int i = 0; i < array.length; i = i + gap * 2) {
                //[i,i+gap)  [i+gap,i+2*gap)
                int left = i;
                int right = i + 2*gap;
                int mid = i + gap;

                if(mid >= array.length) {
                    mid = array.length;
                }
                if(right >= array.length) {
                    right = array.length;
                }
                merge(array,left,mid,right);
            }
            
        }

    }



    public static void main(String[] args) {
        int[] array = {1, 3, 2, 6, 4, 5, 9, 7, 8, 0};
        sortByLoop(array);
        System.out.println(Arrays.toString(array));
    }

}
