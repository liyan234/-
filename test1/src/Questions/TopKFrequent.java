package Questions;


import java.lang.management.MemoryManagerMXBean;
import java.util.*;

/*
给一非空的单词列表，返回前 k 个出现次数最多的单词。
返回的答案应该按单词出现频率由高到低排序。
如果不同的单词有相同出现频率，按字母顺序排序。

输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
*/
public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> map = new HashMap<>();

        //统计单词的个数
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0) + 1);
        }

        List<String> list = new LinkedList<>();

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2) {
                    return o1.compareTo(o2);
                }
                return count2 - count1;
            }
        });

        return list.subList(0,k);
    }
}
