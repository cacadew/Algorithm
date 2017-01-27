package DynamicProgramming1;

import java.util.Scanner;
/*
 * 2 x n 타일링
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 * 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
 * 
 * 접근방법
 * 1) 2xn 크기를 채우는 방법은 2x(n-1)사각형에 2x1 사각형 하나를 채우는 방법 1가지와
 * 2) 2x(n-2) 사각형에 1x2 사각형 2개를 채우는 방법 1가지가 있다.
 * 3) 따라서 memo[i] = memo[i-1]+memo[i-2];
 * 4) 주의★  memo[i] %=10007 계산은 memo[i]가 계산될때 바로 해야함 안그럼 답 오류
 */
public class P11726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] memo = new int[num+1];
		
		memo[0] = memo[1] = 1;
		//memo[0] = 1;
		//memo[1[ = 1; 이렇게 나눠서 쓰는게 더 좋음.
		
		for(int i = 2;i<=num;i++){
			memo[i] = memo[i-1]+memo[i-2];
			memo[i] %=10007;
		}
		System.out.println(memo[num]);
	}
}
