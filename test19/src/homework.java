import java.util.Scanner;

public class homework {

   /* public static int fib(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        else {
            return (fib(i - 2) + fib(i - 1));
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("求斐波那契第n项：");
        int i = scan.nextInt();
        int ret = fib(i);
        System.out.println(ret);
    }*/

//求和
  /* public static int sum(int i) {
        while(i != 0) {
            int tmp = 0;
            tmp = i % 10;
            i = i / 10;
            sum = sum + tmp;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int i = scan.nextInt();
        int ret = sum(i);
        System.out.println(ret);
    }*/

   /* public static void print(int i) {
        while(i != 0) {
            print(i/10);
            System.out.print(" " + i%10);
            return;
        }

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int i = scan.nextInt();
        print(i);
    }*/

    /*public static int sum(int i) {
        if(i == 1) {
            return 1;
        } else {
            return sum(i-1) + i;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int i = scan.nextInt();
        int ret = sum(i);
        System.out.println(ret);
    }*/

     public static int sum(int i) {
         if(i == 1) {
             return 1;
         } else {
             return i*sum(i-1);
         }

     }

     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         System.out.println("请输入一个整数：");
         int i = scan.nextInt();
         int ret = sum(i);
         System.out.println(ret);
     }
}
