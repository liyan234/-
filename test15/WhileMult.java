

public class WhileMult {
	public static void main(String[] args) {
		int i = 1;
		
		while(i <= 9 ) {
			int j = 1; 
			while( j <= i) {
				System.out.print("  " + j + "*" + i + "=" + j*i);
				j++;
			}
			i++;
			System.out.print("\n");
		}
	}
}