import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str1 = "hh";

        //获取String类中的value字段，这个value和String原码中的value是匹配的
        Field valueField = String.class.getDeclaredField("value");//抛出异常
        //将这个字段的访问属性设为true
        valueField.setAccessible(true);
        //把str1中的value属性获取到
        char[] value = (char[]) valueField.get(str1);//抛出异常
        //修改
        value[0] = 'a';
        System.out.println(str1);//ah

    }
}
