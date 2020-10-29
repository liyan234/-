
import java.util.Scanner;
public class Num {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		switch(i) {
			case 1:
			System.out.println("轻工学院");
			break;
			case 2:
			System.out.println("材料学院");
			break;
			case 3:
			System.out.println("电信学院");
			break;
			case 4:
			System.out.println("电智学院");
			break;
			case 5:
			System.out.println("文理学院");
			break;
			default:
			System.out.println("输入错误，请重新输入！");
		}
	}
}