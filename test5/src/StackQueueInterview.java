
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackQueueInterview {

    public static boolean isValid(String s){
        if(s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        /*  1: map.put('{','}');
        map.put('(',')');
        map.put('[',']');*/

        map.put('}','{');
        map.put(')','(');
        map.put(']','[');


        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

           /* if(x == '(' || x == '{' || x == '[') {
                stack.push(x);
                continue;
            }*/
           //左括号入栈
            /* 1: if(map.get(x) != null) {
                stack.push(x);
                continue;
            }*/

            if(map.get(x) == null) {
                stack.push(x);
                continue;
            }
            //右括号，看匹配。是否为空栈
            if(stack.empty()) {
                return false;
            }

            Character y = stack.pop();//y是取出来的左括号
           /* if(y == '(' && x == ')') {
                continue;
            }
            if(y == '[' && x== ']') {
                continue;
            }if(y == '{' && x== '}') {y
                continue;
            }*/
           /*1:  if( map.get(y).equals(x)) {
               continue;
           }*/

           if(map.get(x).equals(y)) {
               continue;
           }
            return false;
        }

        if(stack.empty()) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        //构建一个字符串，其中只有{}[]()六种字符
        //构建一个函数，看输出的字符串中括号是否匹配

        String s = "{{{{}}}}";
        String x = "{(})";
        String y = "{()}";

        System.out.println(isValid(s));
        System.out.println(isValid(x));
        System.out.println(isValid(y));

    }
}
