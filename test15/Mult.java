

public class Mult {
	public static void main(String[] args) {
		int i = 1;
		int j = 1;
		for(i = 1; i <= 9; i++) {
			for(j = 1; j <= i; j++){
				System.out.print(" " + j + "*" + i + "=" + i*j);
			}
			System.out.println("\n");
		}
		
	}
}