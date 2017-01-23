package InputOutput;

import java.util.Scanner;

public class P11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		int n=0;
		
		for(int i = 0; i<tc;i++){
			n = n+ (str.charAt(i)-48);
		}
		System.out.println(n);
	}
}
