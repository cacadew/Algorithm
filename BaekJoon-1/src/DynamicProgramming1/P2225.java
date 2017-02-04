package DynamicProgramming1;

import java.util.Scanner;
/* 합분해
 * 0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
 * 덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.
 * 첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.
 * 
 * 접근방법
 * 1) D[k][n] 은 n을  k개 더해서 그 합이 n이 되는 경우의 수 이다.
 * 2) 어떤 수(N) = 합의 마지막으로 더해지는 수(L) + N-L을 만드는데 k-1개를 더해 만드는 경우의 수
 * 3) 마지막 더해지는 수를 기준으로 접근하면 된다.
 * 4) D[k][n-1]이 D[k-1][0~n-1]까지의 합이므로, 점화식 D[k][n] = D[k][n-1]+D[k-1][n] 이다.
 */
public class P2225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] d = new int[k+1][n+1];
		
		for(int i = 0;i<n+1;i++){
			d[1][i] = 1;
		}
		for(int i = 2;i<=k;i++){
			d[i][0] = 1;
			for(int j = 1;j<n+1;j++){
				d[i][j] = d[i][j-1]+d[i-1][j];
				d[i][j] %= 1000000000;
			}
		}
		
		System.out.println(d[k][n]);
	}
}
