import java.util.Scanner;

public class Test6 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int w = sc.nextInt();
            int h = sc.nextInt();

            if (w % 4 == 0 || h % 4 == 0) {
                System.out.println( (w*h) / 2);
                return;
            }

            System.out.println( (w*h)/2 + 1);
        }
    }
}
