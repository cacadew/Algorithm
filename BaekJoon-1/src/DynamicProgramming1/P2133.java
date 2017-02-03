package DynamicProgramming1;

import java.util.Scanner;
/* 타일 채우기
 * 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
 * 
 * 접근방법
 * 1) 3*2 일때 3가지
 * 2) 3*4 일때  ㅡ ㅡ
 *           l=l 이러한 조합이 생겨난다. 뒤집을 경우까지 *2
 * 3) 3*6, 3*8 에서도 이러한 조합이 2개씩 생겨나기 때문에 점화식은
 * 4) D[i] = D[i-2]*3 + D[i-4]*2 + D[i-6]*2 + ~ + D[i-i]*2;
 * 
 */
public class P2133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] d = new int[n+1];
		
		if(n == 1 || n == 3){// n이 3보다 작을 경우 런타임에러가 나기 때문에 예외처리
			System.out.println(1);
			return;
		}
		else if( n == 2){
			System.out.println(3);
			return;
		}
		
		d[0] = 1;
		d[1] = 1;
		d[2] = 3;
		//d[4] = 11;
		for(int i = 4;i<=n;i=i+2){
			d[i] += d[i-2]*3;
			for(int j = 4;j<=i;j=j+2){
				d[i] += d[i-j]*2;
			}
		}
		
		System.out.println(d[n]);
	}
}
