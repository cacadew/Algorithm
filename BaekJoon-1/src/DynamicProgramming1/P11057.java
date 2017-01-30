package DynamicProgramming1;

import java.util.Scanner;
/*
 * 오르막 수 
 * 오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이 때, 인접한 수가 같아도 오름차순으로 친다.
 * 예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.
 * 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.
 * 
 * 접근방법
 * 1) 2차원배열 d[n+1][10]을 만든다. d[i][j]에는 n의 자릿수의 가장 마지막 1의자리에서  숫자 j가 몇번 나오는지가 저장된다.
 * 2) d[1]은 모두 0~9 다 가능 하므로 1을 넣어준다.
 * 3) 2행 이상부터는 d[n][j]는 d[n-1][0]~d[n-1][j]까지의 합이다.
 * 4) d[n][j-1]은 d[n-1][0]~d[n-1][j-1]까지의 합이므로, d[n][j] = d[n][j-1]+d[n-1][j] 임을 알 수 있다.
 */
public class P11057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] d = new int[n+1][10];
		
		for(int i = 0;i<10;i++){// 1의자리 숫자일 경우 0~9 각각 가능하므로 1을 넣음
			d[1][i] = 1;
		}
		
		for(int i = 2;i<=n;i++){
			for(int j = 0;j<10;j++){
				if(j == 0)
					d[i][j] = 1;// 0의경우 다 0일 경우밖에 안되므로 항상 0
				else{
					d[i][j] = d[i][j-1]+d[i-1][j];
				}
				d[i][j] %= 10007;
			}
		}
		int ans=0;
		for(int i =0;i<10;i++){
			ans += d[n][i];
		}
		System.out.println(ans%=10007);
	}
}
