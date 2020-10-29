/*public class IfTest {
	public  static void main(String[] args) {
		int a = 91;
		if(a < 60)
		{
			System.out.println("不及格");
		}
		else
		{
			if(a < 80)
			{
				System.out.println("中");
			}
			else
			{
				if (a < 90)
				{
					System.out.println("良");
				}
				else
				{
					if(a < 100)
					{
						System.out.println("优秀");
					}
				}

			}
		}
		
	}

}*/
/*public class IfTest {
	 public static void main(String[] args) {
	 	int score = 98;
	 	int temp = score / 10;
	 	switch(temp)
	 	{
	 		case 10:
	 		case 9:
	 		System.out.println("成绩优秀");
	 		break;
	 		case 8:
	 		System.out.println("成绩良");
	 		break;
	 		case 7:
	 		System.out.println("成绩中");
	 		break;
	 		case 6:
	 		System.out.println("成绩及格");
	 		break;
	 		default:
	 		System.out.println("成绩不及格");
	 		break;
	 	}
	}
}*/
/*public class IfTest {
	public static void main (String[] args) {
		int a = 2020;
		int temp = a % 12;
		switch(temp)
		{
			case 0:
			System.out.println("鼠年");
			break
			case 1;
			System.out.println("牛年");
			break;
			case 2;
			System.out.println("虎年");
			break;
			case 3;
			System.out.println("兔年");
			break;
			case 4;
			System.out.println("龙年");
			break;
			case 5;
			System.out.println("蛇年");
			break;
			case 6;
			System.out.println("马年");
			break;
		} 
	}
}*/
/*	public static void main (String[] args) {
		int a = 1;
		switch(a)
		{
			case 1:
			System.out.println("31");
			break;
			case 2:
			System.out.println("28");
			break;
			case 3:
			System.out.println("31");
			break;
			case 4:
			System.out.println("30");
			break;
			case 5:
			System.out.println("31");
			break;
			case 6:
			System.out.println("30");
			break;
			case 7:
			System.out.println("31");
			break;
			case 8:
			System.out.println("31");
			break;
			case 9:
			System.out.println("30");
			break;
			case 10:
			System.out.println("31");
			break;
			case 11:
			System.out.println("30");
			break;
			case 12:
			System.out.println("31");
			break;
		}

	}
}*/
/*public class IfTest {
	public static void main (String[] args) {
		int sum = 0;
		int i = 0;
		int j = 0;

		while(i <= 100)
		{
			while ( (i % 3) == 0 && (i % 5) == 0 )
			{
				j = i;
				sum = sum + j;
			}
			i = i + 1;
		}
		System.out.println(sum);
	}
}*/

public class IfTest {
	public static void main(String[] args) {
		long i = 1;
		long sum = 1;
		for( i = 1; i <= 10; i++)
		{
			if( i%2 == 0)
			{
				sum = sum * i;
			}
		}
		System.out.println(sum);
	}
}