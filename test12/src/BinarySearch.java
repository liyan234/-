import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void binarySearch(int[] array,int key) {
        int right = array.length-1;
        int left = 0;
        while(left <= right) {
            int mid = (right + left) / 2;
            if(array[mid] == key) {
                System.out.println("找到了，在数组编号为" + mid + "位置");
                return;
            } else if(key > array[mid]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        System.out.println("找不到");
        return;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(array));
        System.out.println("请输入关键字：");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        binarySearch(array,key);
    }
}
