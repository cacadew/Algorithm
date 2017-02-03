package DynamicProgramming1;

import java.util.Scanner;
/* 계단오르기
 * 계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.
 * 계단 오르는 데는 다음과 같은 규칙이 있다.
 *  1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 *  2. 연속된 세 개의 계단을 모두 밟아서는 안된다. 단, 시작점은 계단에 포함되지 않는다.
 *  3. 마지막 도착 계단은 반드시 밟아야 한다.
 * 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최대값을 구하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 포도주 문제 (P2156)과 비슷하게 2가지 방법으로 접근이 가능하다.
 * 1. 2차원 배열 사용해서 풀기
 *  2) 2차원 배열을 사용하면 0번 연속 오르는 경우, 1번 연속 오르는 경우, 2번 연속 오르는 경우가 있다. 주의해야할 점은 0번 오르는 경우는 조건1에 위배되므로 제외한다.
 *  3) D[i][1] = Math.max(D[i-2][1],D[i-2][2])+A[i] 이다. i-1번째는 무조건 밟지 말아야함
 *  4) D[i][2] = D[i-1][1]+A[i] i-1번째에 1번째로 밟은 계단이여야 하므로!
 *  5) 따라서 정답은 Math.max(D[n][1], D[n][2])이다.
 * 
 * 2. 1차원 배열 사용해서 풀기
 *  1) D[i] = i번째 계단에 올라갔을 때, 얻을 수 있는 최대점수
 *  2) 1개 연속일 때 => D[i] = D[i-2]+A[i]
 *  3) 2개 연속일 때 => D[i] = D[i-3]+A[i-1]+A[i];
 */
public class P2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] stair = new int[n+1];
		int[] d = new int[n+1];
		
		for(int i = 1;i<n+1;i++){
			stair[i] = sc.nextInt();
		}
		
		d[1] = stair[1];
		d[2] = stair[1]+stair[2];
		d[3] = Math.max(stair[1], stair[2]) + stair[3]; // 처음 3까지는 점화식의 i-3 때문에 직접 값을 넣어준다.
		
		for(int i = 4;i<n+1;i++){
			if(d[i-2]+stair[i] <d[i-3]+stair[i-1]+stair[i]){//i번째에 얻을 수 있는값이 1번연속일때가 작고 2번 연속일때가 크냐???
				d[i] = d[i-3]+stair[i-1]+stair[i];
			}
			else{
				d[i] = d[i-2]+stair[i];
			}
		}
		System.out.println(d[n]);
	}
}