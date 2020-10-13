package Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，
     * 其余每个元素均出现两次。找出那个只出现了一次的元素。
     * */

    //解法一
    public int singleNumberOne(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int num: nums) {

            Integer count = map.get(num);

            if (count == null) {
                map.put(num,1);
            } else {
                map.put(num,count + 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    //解法2
    public int singleNumberTwo(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret = ret ^ x;
        }
        return ret;
    }

    /**
     * 给定一个非空整数数组，其中有2个元素只出现一次以外，
     * 其余每个元素均出现两次。找出那2个只出现了一次的元素。
     * */
    public int[] singleNumber(int[] nums) {

        int x = 0;
        for (int i: nums) {
            x = x ^ i;
        }

        int bit = 0;
        for (;bit < 32; bit++) {
            if((x & (1 << bit) ) > 0) {
                break;
                //得到第几个bit位
            }
        }

        int a = 0;
        int b = 0;
        for (int i : nums) {

            if ((i & (1 << bit)) > 0) {
                a = a ^ i;
            } else {
                b = b ^ i;
            }
        }

        int[] array = {a,b};
        return array;
    }


}
