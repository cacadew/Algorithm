package DynamicProgramming1;

import java.util.Scanner;

/*
 * 2xn 타일링 2
 * 2×n 직사각형을 1x2,2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) n번째 사각형을 만드는 방법은 n-1번째 사각형에 2x1 사각형 하나를 붙이는 방법 한가지
 * 2) n-2번째 사각형에 2x2사각형을 하나 붙이는 방법 한가지
 * 3) n-2번째 사각형에 1x2 사각형 두 개를 붙이는 방법 한가지, 총 3가지 방법이 있다.
 * 4) 따라서, memo[i] = memo[i-1] + 2*memo[i-2]; 점화식이 완성된다.
 * 5) memo[0]은 사각형 아무것도 사용하지 않는 방법 한가지 있기 때문에 1을 넣어준다.
 * 
 */
public class P11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] memo = new int[n+1];
		memo[0] = 1;
		memo[1] = 1;
		
		for(int i = 2; i<=n;i++){
			memo[i] = memo[i-1]+2*memo[i-2];
			memo[i] %= 10007;
		}
		System.out.println(memo[n]);
		
	}
}
