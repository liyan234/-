import javafx.scene.chart.ScatterChart;

public class MainThree {

    public static void main(String[] args) {
        int[] arrays = {1,2,3,4};

        int x = 1;
        int p = 0;
        if(p == 0) {
            throw new ArithmeticException("分母不可以为零");
        } else {
            System.out.println(x/p);
        }

        int[] nums = new int[10];
        try {
            for(int i=0;i<10;i++) {
                System.out.println(nums[i]);
            }
            System.out.println(5/nums[2]);
        } catch(ArithmeticException ex) {
            System.out.println("除0的算数异常");
        } catch(ArrayIndexOutOfBoundsException ex) {
            //标明处理的异常类的类名
            System.out.println("数组下标越界异常");
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println("程序结束");
        /*try {
            for (int i = 0; i < 6; i++) {
                System.out.println(arrays[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }*/

        System.out.println("程序结束");
    }
}
