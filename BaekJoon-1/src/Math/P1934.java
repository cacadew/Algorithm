package Math;

import java.util.Scanner;
/*
 * 최소공배수 - P2609 접근방법 참고
 */
public class P1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		while(tc-->0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int temp = a*b;
			
			while(b != 0){
				int r = a%b;
				a = b;
				b = r;
			}
			
			long ans = temp/a;
			System.out.println(ans);
			
		}
		
	}
}
