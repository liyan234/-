package examFinal;

import java.util.ArrayList;


public class Two {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null) {
            return  null;
        }
        if (k == 0) {
            return null;
        }


        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                if (input[i] > input[j]) {
                    int tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] ip = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> list = GetLeastNumbers_Solution(ip,k);
        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i));
        }
    }
}
