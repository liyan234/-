package Questions;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
 * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 */
public class NumJewelsInStones {



    public int numJewelsInStones(String J, String S) {
       /* int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char A = S.charAt(i);
            if (J.contains(A + "")) {
                count ++;
            }
        }
        return count;*/


       int count = 0;

       //统计宝石的种类
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        //看宝石是否和你的石头相等
        for (int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))) {
                count++;
            }
        }
       return count;
    }
}
