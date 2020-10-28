//有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。 
/*public class Start {
	public static int differentNum(int[] nums) {
		  int num = 0;
		  for(int i = 0; i < nums.length; i++) {
		   	num = num ^ nums[i];
		  }
		  return num;
	}

	public static void main(String[] args) {
		  int [] nums = new int[]{1,2,3,4,1,2,3,4,5};
		  System.out.println(differentNum(nums));
	}
}
*/
//斐波那契数的第n项  迭代实现
/*import java.util.Scanner;
public class Start {
	public static int fib(int num) {
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		int i = 2;
		if( num <= 2) {
			return 1;
		}
		while( i < num) {
			int temp = 0;

			num3 = num1 + num2;
			temp = num2;
			num2 = num3;
			num1 = temp;
  			i++;
		}
		return num3;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入求斐波那契数的第几位：");
		int a = scan.nextInt();
		System.out.println(fib(a));
	}
}*/

//求阶乘和。
/*import java.util.Scanner;
public class Start {
	public static int facSum(int num) {
		int sum = 0;

		for(int i = 1; i <= num; i++) {
			int ret = 1;
			for(int j = 1;j <= i; j++){
				ret *= j; //阶乘
			}
			sum = ret + sum;//阶乘和
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println("求n的阶乘的和，输入n：");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();

		System.out.println(facSum(a));
	}
}*/

/*import java.util.Scanner;
public class Start {
	public static int fac(int num) {
		int sum = 1;
		for(int i = 1; i <= num; i++) {
			sum *= i;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println("求n的阶乘,输入n：");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();

		System.out.println(fac(a));
	}
}*/

//调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序

/*public class Start {
	public static void array(int[] nums) {
		int i = 0;
		for(i = 0;i < nums.length; i++) {
			if(nums[i] % 2 != 0) {
				System.out.print(" " + nums[i]);
			}
		}
		for(i = 0; i < nums.length; i++) {
			if(nums[i] % 2 == 0) {
				System.out.print(" " + nums[i]);
			}
		}
	}

	public static void main(String[] args) {
		int [] nums = new int[]{1,2,3,4,5,6,7};
		//int [] nums = new int[]{1,2,3,4,1,2,3,4,5};
		array(nums);
	}
}*/


/*import java.util.Scanner;
public class Start {
	public static int twoMax(int a, int b) {
		return a >=b ? a : b;
	}

	public static int threeMax(int a,int b,int c) {
		int i = twoMax(a,b);
		int j = twoMax(i,c);
		return j;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入三个数比较大小");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();

		System.out.print("前两个数比较大小：");
		System.out.println(twoMax(a,b));

		System.out.print("三个数比较大小:");
		System.out.println(threeMax(a,b,c) );
	}

} */

/*import java.util.Scanner;
public class Start {

	public static int big(int a, int b) {
		return a >=b ? a : b;
	}

	public static double big(double a, double b) {
		return a >=b ? a : b;
	}

	public static double big(int a, double b) {
		return (double)a >=b ? (double)a : b;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("请输入两个整数:");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println("请输入两个小数:");
		double c = scan.nextDouble();
		double d = scan.nextDouble();

		System.out.print("两个整数的最大值:");
		System.out.println(big(a,b));

		System.out.print("两个小数的最大值:");
		System.out.println(big(c,d));

		System.out.print("第一个整数和第一个小数的最大值:");
		System.out.println(big(a,c));

    }
}*/
import java.util.Scanner;
public class Start {
	public static int add(int a, int b) {
		return a + b;
	}

	public static double add(double a, double b, double c) {
		return a + b + c; 
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("请输入两个整数:");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println("请输入三个小数:");
		double c = scan.nextDouble();
		double d = scan.nextDouble();
		double e = scan.nextDouble();

		System.out.print("两个整数的和:");
		System.out.println(add(a,b));

		System.out.print("三个小数的和:");
		System.out.println(add(c,d,e));
    }
}
