package 快排;


import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

//时间复杂度:最坏情况O(N^2)    对一个降序的数组，用快排进行升序排序
//            平均情况O(NLogN)
//空间复杂度:最坏O(N)  平均 O(LongN)
//不稳定排序
public class Test {

    //快速排序递归写法
    public static void sort(int[] array) {
        helpSort(array,0,array.length-1);
    }

    private static void helpSort(int[] array, int left, int right) {

        if(left >= right) {
            return;
        }

        int index = part(array,left,right);

        helpSort(array,left,index-1);

        helpSort(array,index+1,right);
    }

    private static int part(int[] array, int left, int right) {
        //优化代码
        /**优化的代码
         * 随机选择三个数字，取这三个数字的中间值为基准值
         * if(array.length >= 3) {

            Random random = new Random();
            int[] help = new int[3];
            help[0] = array[left];
            help[1] = array[right];
            int x = random.nextInt(right);
            help[2] = array[x];

         //使用冒泡排序将这含有三个数的数组排序
            for (int i = 0; i < help.length; i++) {

                for (int j = help.length - 1; j > i; j--) {
                    if (help[j] > help[j - 1]) {
                        int tmp = help[j];
                        help[j] = help[j - 1];
                        help[j - 1] = tmp;
                    }
                }
            }

            for (int i = 0; i < array.length; i++) {
                if (array[i] == help[1]) {
         //交换left和i的位置
                    array[i] = array[left];
                    array[left] = help[1];
                    break;
                }
            }
        }*/


        int baseVal = array[left];

        int i = left;
        int j = right;

        while (i < j) {

            while(i < j && array[j] >= baseVal) {
                j--;
            }

            while(i < j && array[i] <= baseVal) {
                i++;
            }

            if(i < j) {
                swap(array,i,j);
            }
        }

        swap(array,j,left);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    //快速排序的非递归写法
    public static void sortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        if(array.length == 0) {
            return;
        }
        //栈 先进后出
        stack.push(0);//left
        stack.push(array.length-1);//right

        while(!stack.isEmpty()) {

            int right = stack.pop();
            int left = stack.pop();

            if(right <= left ) {
                continue;
            }
            int index = part(array,left,right);

            //左子树入栈
            stack.push(left);//left
            stack.push(index-1);//right
            //右子树入栈
            stack.push(index + 1);//left
            stack.push(right);//right
        }

    }






    public static void main(String[] args) {
        int[] array = {1, 3, 2, 6, 4, 5, 9, 7, 8, 0};
        sortByLoop(array);
        System.out.println(Arrays.toString(array));
    }

}
