package Questions;

public class SortColors {

    /**给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
     * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

     此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

     输入: [2,0,2,1,1,0]
     输出: [0,0,1,1,2,2]
     */
    public void sortColors(int[] nums) {

        int p1 = 0;
        int p2 = nums.length - 1;
        int cur = 0;

        while (cur <= p2) {

            if (nums[cur] == 0) {
                int tmp = nums[p1];
                nums[p1] = nums[cur];
                nums[cur] = tmp;
                p1++;
                cur++;

            } else if (nums[cur] == 2) {
                int tmp = nums[p2];
                nums[p2] = nums[cur];
                nums[cur] = tmp;
                p2--;

            } else {
                cur++;
            }
        }

    }
}
