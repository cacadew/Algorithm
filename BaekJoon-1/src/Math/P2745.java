package Math;

import java.util.Scanner;
/*
 * 진법변환
 * B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 * A: 10, B: 11, ..., F: 16, ..., Y: 34, Z: 35
 * 
 * 접근방법
 * 1) 3진법 수 102 일때, 우리가 주로 사용하는 10진수 변환법은 제일 마지막 2부터 계산하는것이다.
 *    하지만 1부터 계산하는 더 쉬운 방법이 있음!!!!!!
 * 2) (1x3+0)x3+2 이렇게 1부터 시작. (a[0]xn + a[1])xn + a
 * 3) a[0] 일때는 ans = 0이기 때문에  0*n + a[0] 으로 시작함
 */
public class P2745 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.next();
		int b = sc.nextInt();
		char[] a = line.toCharArray();
				
		long ans = 0;
		
		for(int i = 0;i<a.length;i++){
			char c = a[i];
			
			if(c>'9')//문자일때
				ans = ans*b + c-'A'+10;
			else
				ans = ans*b + c-48;
		}
		
		// 평소 사용하던 10진법 변환방법(마지막부터 하는거)
		/*for(int i = 0;i<a.length;i++){ 
			char c = a[a.length - i-1];
			
			if(c > '9'){
				ans += (c-'A'+10)*(Math.pow(b, i));
			}
			else{
				ans += (c - 48)*(Math.pow(b, i));
			}
		}*/
		
		System.out.println(ans);
	}
}
