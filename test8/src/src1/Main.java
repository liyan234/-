package src1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Main {

    private static final int NUM = 5;//定义产生随机值的上限
    private static boolean isEqual(int x,int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(x == array[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] ranInt(int[] array) {
        Random random = new Random();
        int count = 0;
        while(count < 5) {
            int x = random.nextInt(NUM) + 1;
            if(isEqual(x,array)) {
                array[count] = x;
                count++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        ranInt(array);
        System.out.println(Arrays.toString(array));
    }
}
