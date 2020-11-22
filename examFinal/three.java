package examFinal;

import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//几个桌子
            int m = sc.nextInt();//几批客人

            //最大容纳的客人
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            //客人
            int b[] = new int[m];
            int c[] = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
                c[i] = sc.nextInt();
            }

            int sum = getMoney(n ,m , a, b , c);
        }
    }

    private static int getMoney(int n, int m, int[] a, int[] b, int[] c) {
        int sum = 0;
        if (m <= n){
        }
        return sum;
    }
}
