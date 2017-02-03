package DynamicProgramming1;

import java.util.Scanner;
/* 파도반 수열
 * 오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다. 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다.
 * 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
 * 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
 * N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) 삼각형 그림을 봤을 때 D[i] = D[i-1] + D[i-5]; 이다.
 * 2) 수열을 봤을때 D[i] = D[i-2] + D[i-3];도 된다. 두가지 점화식 둘다 가능
 */
public class P9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		while(tc-->0){
			int n = sc.nextInt();
			if(n<4){
				System.out.println(1);
				continue;
			}
						
			long[] d = new long[n+1];
			d[1] = d[2] = d[3] = 1;
			
			for(int i = 4;i<n+1;i++){
				d[i] = d[i-2] + d[i-3];
			}
			
			System.out.println(d[n]);
			
		}
	}
}
