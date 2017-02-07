package Math;

import java.util.Scanner;

/* 최대공약수(GCD)와 최소공배수(LCM)
 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) GCD를 빠르게 구하는 방법은 유클리드 호제법을 이용하는 것이다.
 * 2) GCD(a, b) == GCD(b, a%b) 이다. a%b가 0이면, 그 때 b가 최대공약수이다.
 * 3) 유클리드 호제법 구현 방법에는 재귀함수를 이용하는 것과 while문을 사용하는 것이 있다.
 * 
 * 4) GCD*LCM == a*b 이다. 따라서 LCM == (a*b)/GCD 이다.
 * 5) 이때 a와 b는 int형일지라도 최소공배수는 int 범위가 넘을 수도 있기 때문에 주의해야 한다.
 * 
 */
public class P2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		long temp = a*b;
		
		while(b != 0){
			int r = a%b;
			a = b;
			b = r;
		}
		
		long lcm = temp/a;
		
		System.out.println(a);
		System.out.println(lcm);
	}
}
