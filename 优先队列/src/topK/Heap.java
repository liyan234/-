package topK;

import java.util.*;

public class Heap {

    static class nums{
        public int num1;
        public int num2;
        public int sum;

        public nums(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
        }
    }



    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ret = new LinkedList<>();

        if(k == 0) {
            return ret;
        }

        PriorityQueue<nums> queue = new PriorityQueue<>(new Comparator<nums>() {
            @Override
            public int compare(nums o1, nums o2) {
                return o1.sum - o2.sum;
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new nums (nums1[i],nums2[j]));
            }
        }


        for (int i = 0; i < k && !queue.isEmpty() ; i++) {
            nums cur = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur.num1);
            tmp.add(cur.num2);
            ret.add(tmp);
        }
        return ret;
    }
}
