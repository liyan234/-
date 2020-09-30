import java.util.Scanner;

public class Test12 {
    public static void main(String[] args) {

        Object o = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (o) {
                        try {
                            System.out.println("wait开始");
                            o.wait();
                            System.out.println("wait结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("任意输出一个属，执行notify");
                int x = scanner.nextInt();
                synchronized (o) {
                    System.out.println("notify 开始");
                    o.notify();
                    System.out.println("notify 结束");
                }
            }
        };
        t2.start();
    }
}
