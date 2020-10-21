import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainThree {

    private static final int NUM = 33;
    private static final int AMOUNT = 7;

    public static Integer[] getAmount()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        list.add(random.nextInt( NUM )+1);//产生的第一个数是不重复的，可以直接放到容器中
        while(list.size() < AMOUNT) {
            int temp = random.nextInt( NUM )+1;//产生一个新的随机数
            if(!list.contains(temp)) {//判断容器中是否已经存在这个随机数
                list.add(temp);
            }
        }
        return (Integer[])list.toArray(new Integer[list.size()]);
    }

    public static void main(String[] args) {

        Integer[] array = getAmount();
        System.out.println(Arrays.toString(array));

    }

}
