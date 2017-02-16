package Graph;

import java.util.Arrays;
import java.util.Scanner;
/* 단지번호붙이기 - dfs
 * 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 연결된 집들의 모임을 단지라고 정의하고 단지에 번호를 붙이려 한다.
 * 여기서 연결되었다는 것은 어떤집이 좌우, 혹은 위아래로 다른 집이 있는 경우를 말한다. 대각선은 안된다.
 * 지도를 입력하여 단지 수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하라
입력:
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

출력:
3
7
8
9

 * 접근방법
 * 1) 연결요소를 찾는 것과 같다. dfs나 bfs 어떤방법으로도 가능하다.
 * 2) 연결요소를 찾을 때, map에 1이 표시가 됐는지를 확인하고, cache에 해당 좌표가 방문이 됐는지를 확인한다.
 * 3) 좌우 위 아래에 조건을 확인하여 집을 찾는다.
 */
public class P2667_dfs {
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, 1, -1};
	
	static int[][] map;
	static int[][] cache;
	static int c=2;
	
	static void apt(int x, int y){
		cache[x][y] = c;
		
		for(int i = 0; i<4;i++){
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx <map.length && ny>=0 && ny<map.length && cache[nx][ny] == 0 && map[nx][ny] == 1){
				apt(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		sc.nextLine();
		
		map = new int[size][size];
		cache = new int[size][size];
		
		for(int i = 0; i<size;i++){
			String line = sc.nextLine();
			for(int j = 0; j<size;j++){
				map[i][j] = line.charAt(j)-48;
			}
		}
		
		for(int i = 0; i<size;i++){
			for(int j = 0; j<size;j++){
				if(map[i][j] ==1 && cache[i][j] == 0){
					apt(i,j);
					c++;
				}
			}
		}
		System.out.println(c-2);
		int[] aptNum = new int[c-2]; // c가 2부터 카운트 됐고, 마지막에도 +1이 됐으므로 2를 빼줘야함
		for(int i = 0;i<size;i++){
			for(int j = 0; j<size;j++){
				if(cache[i][j] >1)
					aptNum[cache[i][j]-2]++;
			}
		}
		Arrays.sort(aptNum);
		for(int i = 0; i<aptNum.length;i++){
			System.out.println(aptNum[i]);
		}
		
		
		
		
	}
}
