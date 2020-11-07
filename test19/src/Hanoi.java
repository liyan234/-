import java.util.Scanner;

public class Hanoi {
    public static void move(char m,char n) {
        System.out.print(m + ">" + n + " ");
    }
    public static void hanoi(int i,char pos1,char pos2,char pos3) {
        if(i == 1) {
            move(pos1,pos3);
            return;
        }
        hanoi(i-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanoi(i-1,pos2,pos1,pos3);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入汉诺塔上的圆盘数：");
        int i = scan.nextInt();
        hanoi(i,'A','B','C');
    }
}
