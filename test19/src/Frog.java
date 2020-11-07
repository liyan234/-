import java.util.Scanner;

public class Frog {
    public static int frog(int i) {
        if(i == 1) {
            return 1;
        } else if (i == 2){
            return 2;
        } else {
            return frog(i-1)*frog(i-2);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入几阶台阶：");
        int i = scan.nextInt();
        int x = frog(i);
        System.out.println("共有" + x +"种跳法");
    }
}
