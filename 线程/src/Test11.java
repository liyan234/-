import java.util.Scanner;

public class Test11 {
    static class Cou {
        private volatile int flag = 0;
    }

    public static void main(String[] args) {

        Cou  c = new Cou();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (c.flag == 0) {

                }
                System.out.println("循环结束");
            }
        };
        t1.start();

        Thread t2 = new Thread() {

            @Override
            public void run() {
                Scanner sc = new Scanner(System.in);
                System.out.println("随便输入一个不为0的整数");
                c.flag = sc.nextInt();
            }
        };
        t2.start();

    }
}
