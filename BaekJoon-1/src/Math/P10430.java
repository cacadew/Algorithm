package Math;

import java.util.Scanner;

/* 나머지 
 * (A+B)%C는 (A%C + B%C)%C 와 같을까?
 * (A×B)%C는 (A%C × B%C)%C 와 같을까?
 * 세 수 A, B, C가 주어졌을 때, 위의 네가지 값을 구하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) (A+B)%C == (A%C + B%C)%C
 *    (A×B)%C == (A%C × B%C)%C 이다.
 * 2) 나누기의 경우 성립하지 않는다.(modular Inverse를 구해야함)
 * 3) 뺄셈의 경우에는 먼저 mod 연산을 한 결과가 음수가 나올 수 있기 때문에 (A-B)%C == {(A%C)-(B%C)+C}%C 로 해야한다.
 * 4) 보통 DP 문제에서 수의 범위를 넘게 하지 않기 위해 많이 사용한다.
 */
public class P10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int ans = 0;
		
		ans = (a+b)%c;
		System.out.println(ans);
		
		ans = (a%c + b%c)%c;
		System.out.println(ans);
		
		ans = (a*b)%c;
		System.out.println(ans);
		
		ans = ((a%c)*(b%c))%c;
		System.out.println(ans);
	}
}
