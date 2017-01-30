package DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 스티커
 * 2행 n열의 스티커가 있다. 한장을 뜯으면 변을 접하고 있는 스티커가 모두 찢어진다.
 * 각 스티커에 점수가 있다면, 점수의 합이 최대가 되도록 스티커를 뗄 때 얻을 수 있는 점수는?
 * 
 * 접근방법 - 무조건 큰 값을 선택한다고 답이 되지 않음!
 * 1) 스티커를 세로로 쪼개서 접근해야 한다!!! n번째는 sti[0][n]과 sti[1][n]을 나타낸다.
 * 2) n번째 열의 조합은 
 * 	0 : X	1 : O	2 : X
 * 		X		X		O
 * 	이렇게 스티커를 떼는 방법은 3가지가 있다.
 * 3) D[][]은 n x 3의 2차원배열로 만든다.
 * 4) n번째 조합이 0번과 같을 경우, n-1번째에 올 수 있는 조합은 0번,1번,2번 모두 다 가능 하므로  d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
 *	  n번째 조합이 1번과 같을 경우, n-1번째에 올 수 있는 조합은 0번,2번만 가능하다. 따라서 d[i][1] = Math.max(d[i-1][0], d[i-1][2])+sti[0][i]; 자기자신까지 더해주기!
 *	  n번째 조합이 2번과 같을 경우, n-1번째에 올 수 있는 조합은 0번,1번만 가능하다. 따라서 d[i][2] = Math.max(d[i-1][0], d[i-1][1])+sti[1][i]; 자기자신까지 더해주기!
 * 5) ans는 D[n][0],D[n][1],D[n][2] 중에서 최대값이 된다.
 */
public class P9465 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		while(tc-->0){
			int n = sc.nextInt();
			
			int[][] sti = new int[2][n+1];
			int[][] d = new int[n+1][3];
			
			for(int i = 0; i<2;i++){
				for(int j = 1;j<=n;j++){
					sti[i][j] = sc.nextInt();
				}
			}
			d[1][0] = 0;
			d[1][1] = sti[0][1];
			d[1][2] = sti[1][1];
			
			for(int i = 2; i<=n;i++){
				d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
				d[i][1] = Math.max(d[i-1][0], d[i-1][2])+sti[0][i];
				d[i][2] = Math.max(d[i-1][0], d[i-1][1])+sti[1][i];
				
			}
			
			int ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
			System.out.println(ans);
			
			
		}//end while(tc)
		
	}//end main
}
