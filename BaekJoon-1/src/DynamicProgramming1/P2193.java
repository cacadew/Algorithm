package DynamicProgramming1;

import java.util.Scanner;
/* 이친수 문제
 * 2진수 n자릿 수를 만들 떼
 * 	조건1. 이친수는 0으로 시작하지 않는다.
 * 	조건2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉 11을 부분 문자열로 갖지 않는다.
 * 
 * 접근방법
 * 1) 문제를 2가지로 쪼개어 볼 수 있다.
 * 	첫번째 - n번째 자리에 0이 오는 경우 => n-1번째 수에 0을 붙여주면 된다.
 * 	두번째 - n번째 자리에 1이 오는 경우 => n-1번째에 1을 붙이면 조건2에 위배되기 때문에
 * 			n-2번째 수에 01 을 붙여준다.
 * 2) D[n] = D[n-1]+D[n-2];
 */
public class P2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		long[] d = new long[(int)n+1];
		
		d[1]= 1;
		if(n>=2)//n == 1일 경우 예외처리
			d[2] = 1;
		
		for(int i = 3;i<=n;i++){
			d[i] = d[i-1]+d[i-2];
		}
		System.out.println(d[(int)n]);
	}
}
