package Math;

import java.util.Scanner;
/*
 * 팩토리얼
 * n! 구하기
 */
public class P10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int ans = 1;
		for(int i = n;i>1;i--){
			ans = ans*i;
		}
		
		System.out.println(ans);
	}
}
