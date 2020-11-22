package examTwo;

import java.util.Scanner;

public class stwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String x1 = sc.nextLine();
            int x = Integer.parseInt(x1);

            String str = sc.nextLine();
            String[] strs = str.split(" ");

            int[] arr = new int[strs.length];

            for (int i = 0; i < strs.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j >= 0 ; j--) {
                    if (j == 0) {
                        if (arr[j] < arr[i]) {
                            System.out.print(0 + " ");
                            break;
                        } else {
                            System.out.print(-1 + " ");
                            break;
                        }
                    }
                    if (arr[j] < arr[i]) {
                        System.out.print(j + " ");
                        break;
                    }
                }

                for (int k = i; k < arr.length; k++) {
                    if (k == arr.length-1) {
                        if (arr[arr.length-1] < arr[i]) {
                            System.out.println(arr.length-1 + " ");
                            break;
                        } else {
                            System.out.println(-1 + " ");
                            break;
                        }
                    }
                    if (arr[k] < arr[i]) {
                        System.out.println(k);
                        break;
                    }
                }
            }
        }
    }
}
