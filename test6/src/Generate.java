import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generate {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if(numRows <= 0) {
            return result;
        }

        ArrayList<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1) {
            return result;
        }

        ArrayList<Integer>secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2) {
            return result;
        }

        for (int row = 3; row <= numRows ; row++) {

            List<Integer> prevLine = result.get(row-1-1);
            List<Integer> curLine = new ArrayList<>();

            curLine.add(1);

            for(int col = 2;col <= row-1; col++) {
                int tmp1 = prevLine.get(col-1-1);
                int tmp2 = prevLine.get(col-1);
                curLine.add(tmp1 + tmp2);
            }

            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(generate(i));
    }
}
