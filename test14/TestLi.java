/*import java.util.Scanner;
public class TestLi {
	public static int twoBig(int a,int b) {
		if(a >= b ) {
			return a;
		}
		else {
			return b;		
		}
	}

	public static int threeBig(int a,int b,int c) {
		if( a >= b ) {
			if( a >= c) {
				return a;
			}
			else {
				return c;
			}
		} 
		else {
			if( b >= c) {
				return b;
			}
			else {
				return c;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();

		int i = twoBig(a,b);
		System.out.println("max1" + ":" + i);

		int j = threeBig(a,b,c);
		System.out.println("max2" + ":" + j);
	}
}*/

/*import java.util.Scanner;
public class TestLi {
	public static int fac(int n) {
		int fac = 1;
		for (int i = 1;i <= n; i++) {
			 fac *= i; 
		}
		return fac;
	}


	public static int facSum(int num) {
		int sum = 0;
		for (int i = 1; i <=num ; i++) {
			int ret = 1
			for (int j =1; j <= i; j++) {
				ret *= j;
			}
			sum = ret + sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();

		System.out.println(facSum(a));
	}
}*/

/*import java.util.Scanner;
public class TestLi {
	
	public static int fac(int n) {
		if (n == 1) {
			return 1;
		}
		return n*fac(n-1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int ret = fac(a);
		System.out.println(ret);
	}

}*/

/*import java.util.Scanner;
public class TestLi {

	public static void binary(int a) {
		int j = 0;

        System.out.print("奇数位:");
		for( j = 31; j >= 1; j = j-2) {
			System.out.print( (( a >>> j) & 1) + " ");
		}//奇数位

		System.out.println();
		System.out.print("偶数位:");

		for( j = 30; j >= 0; j = j-2) {
			System.out.print( (( a >>> j) & 1) + " ");
	    }
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("输入一个数：");
		int a = scan.nextInt();
		binary(a);

	}
}*/

/*import java.util.Scanner;
public class TestLi {
	public static void stamp(int a) {
		if(a < 0)
		{
			a = -a;
			System.out.println("-");  
		}

		while (a != 0) {
			int j = 0;
			j = a % 10;
			System.out.println(j);
			a = a / 10;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		stamp(a);
	}
}*/

/*import java.util.Scanner;
public class TestLi {
	public static void mult(int num) {
		int i = 0;
		int j = 0;
		for(i = 1; i <= num; i++) {
			for(j = 1;j <= i; j++) {
				System.out.print("  " + j + "*" + i + "=" + j*i);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入想得到乘法口诀表");
		int a = scan.nextInt();
		mult(a);
	}
}*/