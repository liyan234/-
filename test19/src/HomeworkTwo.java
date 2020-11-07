import java.util.Arrays;

public class HomeworkTwo {

   /* public static double avg(int[] nums){
        double sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            sum = sum + nums[i];
        }
        return sum/nums.length;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        double ret = avg(nums);
        System.out.println(ret);
    }
*/
     /*public static int sum(int[] nums){
         int sum = 0;
         for (int i = 0; i < nums.length ; i++) {
             sum = sum + nums[i];
         }
         return sum;
     }
     public static void main(String[] args) {
         int[] nums = {1,2,3,4,5,6};
         int ret = sum(nums);
         System.out.println(ret);
     }*/

   /* public static void twice(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * 2;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(nums));
        twice(nums);
        System.out.println(Arrays.toString(nums));
    }
*/
   /* public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(",");
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        printArray(nums);
    }*/

    public static void ass(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = j;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[100];
        ass(nums);
        System.out.println(Arrays.toString(nums));
    }
}
