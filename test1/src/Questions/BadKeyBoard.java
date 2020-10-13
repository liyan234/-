package Questions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BadKeyBoard {

    /**按照发现顺序，
     * 在一行中输出坏掉的键。
     其中英文字母只输出大写，每个坏键只输出一次。
     题目保证至少有1个坏键。
     Scanner: 7_This_is_a_test<br/>_hs_s_a_es
     print :7TI
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String scan = scanner.next();//输入的字符
            String pr = scanner.next();//实际被输入的字符

            scan = scan.toUpperCase();
            pr = pr.toUpperCase();

            Set<Character> set = new HashSet<>();

            //统计实际被输入的字符
            for (int i = 0; i < pr.length(); i++) {
                char x = pr.charAt(i);
                set.add(x);
            }

            //坏掉的建
            Set<Character> broke = new HashSet<>();

            //输入的字符 - 实际被输入的字符 = 坏掉的建
            for (int i = 0; i < scan.length(); i++) {
                char x = scan.charAt(i);

                //若是pr中包含这个字符，则这个建是好的
                if(set.contains(x)) {
                    continue;
                }

                //因为已经输出了这个坏掉的建，所以不用二次输出了
                if(broke.contains(x)) {
                    continue;
                }
                //输出坏掉的建，
                System.out.print(x);
                //将其加入到一个set中
                broke.add(x);
            }
            System.out.println();
        }
    }

}
