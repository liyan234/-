
//100中出现多少数字9
/*public class TestLi {
	public static void main(String[] args) {
		int i = 0;
		int temp = 0;
		for( i = 1; i <= 100; i++) {
			if( i % 10 == 9) {
				temp ++;
			}
			if( i % 100 == 99) {
				temp ++;
			}
		}
		System.out.println(temp);
	}
}*/

//输出1000到2000的所有闰年
/*public class TestLi {
	public static void main(String[] args) {
		int i = 1000;
		for(i = 1000; i <= 2000; i++) {
			if( i % 400 == 0 ) {
				System.out.print(" " + i);
			}
			if(i % 4 == 0) {
				if(i % 100 != 0) {
					System.out.print(" " + i);
				}
			}
		}
	}
}*/

//打印1 到 100 的素数

/*public class TestLi {
	public static void main(String[] args) {
		int i = 1;
		int j = 1;
		for(i = 1; i <= 100; i++) {
			int temp = 0;
			for(j = 1; j <= i; j++) {
				if(i % j == 0) {
					temp ++;
				}
			}
			if(temp == 2) {
				System.out.print("  " + i);
			}
		}
	}
}*/


//判断素数
/*import java.util.Scanner;
public class TestLi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = 1;
		int temp = 0;
			for(j = 1; j <= i; j++) {
				if(i % j == 0) {
					temp ++;
				}
			}
			if(temp == 2) {
				System.out.print( i + "是素数");
			}
			else { 
				System.out.print( i + "不是素数");
			}

    }
}*/

/*import java.util.Scanner;
public class TestLi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		if( year < 19) {
			System.out.println("少年");
		}
		else if (year > 18) {
			if( year < 29 ) {
				System.out.println("青年");
			}
			else if(year > 28) {
				if( year < 56) {
					System.out.println("中年");
				}
				else if(year > 55) {
					System.out.println("老年");
				}
			}
		}
	}
}*/


/*import java.util.Scanner;
import java.util.Random;
public class TestLi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random  random = new Random();
		int x = random.nextInt(100);//数字产生

		System.out.println("猜数字游戏");
		System.out.println("请输入你要猜的数字：");

		while(true) {
			int i = scan.nextInt();
			if( i > x) {
				System.out.println("猜大了！");
			}
			else if(i == x) {
				System.out.println("猜中了！");
				break;
			}
			else {
				System.out.println("猜小了！");
			}
		}
		System.out.println("游戏结束！");
		
	}
}*/


//水仙花数
/*import java.lang.Math;
public class TestLi {
	public static void main(String[] args) {
		for ( int i = 1; i <= 999999; i++) {
			int temp = i;
			int count = 0;
			while(temp != 0) {
				temp = temp/10;
				count++;
			}
			temp = i;
			int sum = 0;
			while(temp != 0) {
				sum += Math.pow(temp%10,count);
				temp = temp/10;
			}
			if(sum == i) {
				System.out.print("  " + i);
			}
		}
	}
}*/

/*public class TestLi {
	public static void main(String[] args) {
		double sum1 = 0;
		double sum2 = 0;
		double sum = 0;
		for(double i = 1.0;i <= 100; i = i+2.0) {
			sum1 += 1.0/i;
		}
		for(double j = 2.0;j <= 100; j = j+2.0) {
			sum2 += 1.0/j;
		}
		sum = sum1 - sum2;
		System.out.println(sum);
	}
}
*/
/*public class TestLi {
	public static void main(String[] args) {
		double sum = 0;
		int flg = 1;
		for (int i = 1; i <= 100;i++ ) {
			sum = sum+ 1.0/i * flg;
			flg = -flg;//-1
		}
		System.out.println("输出sum "+ sum);
	
	}
}*/
/*import java.util.Scanner;
public class TestLi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = scan.nextInt();
		int k = i % j;
		while( k != 0) {
			i = j;
			j = k;
			k = i % j;
		}
		System.out.println(j + "最大公约数");
	}
}*/

//二进制中1的个数
/*import java.util.Scanner;
public class TestLi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int count = 0;
		while(i != 0 ) {
			if((i & 1 )== 1) {
				count ++;
			}
			i = i >>> 1;
		}
		System.out.println("二进制中1个数：" + count);
	}
}*/

// 将二进制中奇数位和偶数位分别输出
import java.util.Scanner;
public class TestLi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = 0;
		System.out.print("奇数位:");
		for( j = 31; j >= 1; j = j-2) {
			System.out.print( (( i >>> j) & 1) + " ");
		}//奇数位
		System.out.println();
		System.out.print("偶数位:");
		for( j = 30; j >= 0; j = j-2) {
			System.out.print( (( i >>> j) & 1) + " ");
		}//偶数位
	}
}

//登陆游戏 登录三次失败后就不能登陆了
import java.util.Scanner;
import java.lang.Math;

public class TestLi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 3;
		System.out.println("你有三次机会！");
		while(count != 0) {
			System.out.println("请输入正确的密码：");
			String password = scan.next();
			//在java当中，判断两个字符串是否一样使用方法 equals
			//password.equals("123456")
			
			if(password.equals("123456")) {
				System.out.println("登录成功！");
				break;
			}
			else {
				count--;
				System.out.println("登录失败，你还有" + count + "机会");
			}
		}
	}
}