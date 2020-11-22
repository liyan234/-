package examFinal;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String x = sc.nextLine();
            int max = 0;
            int end = 0;
            int count = 0;
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) >= '0' && x.charAt(i) <= '9') {
                    count ++;
                    if (max < count) {
                        max = count;
                        end = i;
                    }
                } else {
                    count = 0;
                }
            }
            System.out.println(x.substring(end - max + 1, end + 1));
        }
    }
}
