package March9;

import java.util.Scanner;
/* 격자상의 경로
 * NxM 행렬이 있을 때, 배열중 지정한 한 곳(P)을 거쳐 [0][0]에서 [N-1][M-1]까지 가는 최소경로의 경우의 수를 구하라
 * 이동은 1칸 아래 혹은 오른쪽에 인접한 칸으로만 이동 가능하다.
 * 
 * 접근방법
 * 1) 시작점부터 (P)까지의 경로를 구한다.
 * 1-1) 점화식 : D[n][m] = D[n-1][m]+D[n][m-1]
 * 2) map을 초기화 한 후 시작점을 P로 하여 P부터 [n][m]까지의 경로를 구한다.
 * 2-1) 1)의 경우는 시작점에 1을 넣어줬는데, 여기서는 P 위치에 1)에서 구한 경로개수를 넣어주고 시작한다.
 * 
 * 3) 입력값 P는 배열의 인덱스가 아닌 각 칸에 부여된 번호이기 때문에 입력값이 총 3가지로 나누어 인덱스를 찾아준다.
 * 3-1) 0일경우, m으로 나눠떨어질경우, m으로 나눠떨어지지 않는경우 이렇게 3개로 나누어 P의 인덱스를 찾는다.
 */
public class P10164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.next());//열의 개수
		int m = Integer.parseInt(sc.next());//행의 개수
		int k = Integer.parseInt(sc.next());//반드시 지나야 하는 P의 번호
		int ans = 0;
		
		int[][] map = new int[n+1][m+1];
		int pX;//P의 x좌표
		int pY;//P의 y좌표
		
		//P의 위치로 부여된 번호를 배열의 인덱스로 변환하는 과정
		if(k == 0){
			pX = 1;
			pY = 1;
		}
		else if(k%m != 0){
			pX = k/m+1;
			pY = k%m;
		}
		else{//k가 m으로 나누어 떨어질 때
			pX = k/m;
			pY = m;
		}
		
		//시작점부터 P까지의 최단거리 경로 개수 구하기
		map[1][1] = 1;
		for(int i = 1;i<map.length;i++){
			for(int j = 1; j<map[i].length;j++){
				if(i==1 && j==1)//시작점일때는 건너뛰기
					continue;
				if(i <=pX && j<=pY){
					map[i][j] = map[i-1][j]+map[i][j-1];
				}
			}
		}
		ans = map[pX][pY];//초기화 전에 위에서 구한 P까지의 경로 개수를 백업
		map = new int[n+1][m+1];//초기화. 이미 작업한 map을 계속 사용하면 예외처리해야할게 너무 많음
		map[pX][pY] = ans;
		
		//시작점에서 P까지 이미 왔고, 다시 P에서 도착점까지의 경로 구하기
		for(int i = pX;i<map.length;i++){
			for(int j = 1; j<map[i].length;j++){
				if(i == pX && j == pY)// P의 위치일때는 건너뛰기
					continue;
				if(i >=pX && j>=pY){
					map[i][j] = map[i-1][j]+map[i][j-1];
				}
			}
		}
		
		
		
		System.out.println(map[n][m]);
		
	}
}
