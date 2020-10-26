import java.util.Arrays;

public class JudgeOrder {

    public static void judeOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1 ; j++) {
                if(array[j+1] < array[j]) {
                    System.out.print("无序");
                    return;
                }
            }
        }
        System.out.println("有序");
        return;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        int[] array2 = {1,3,2,4,9,7,6};

        System.out.print(Arrays.toString(array) + "  array:");
        judeOrder(array);

        System.out.print(Arrays.toString(array2) + "  array2:");
        judeOrder(array2);
    }
}
