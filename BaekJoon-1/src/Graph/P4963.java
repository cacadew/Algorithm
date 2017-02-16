package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 섬의 개수
 * P2667 문제와 같이, 1로 연결되어 있는 것이 섬일 때, 섬의 개수를 구하는 것이다.
 * 단, 이 문제에서는 대각선으로 연결되어 있는 것도 간선으로 이어진 것이다.
 * 
 * 접근방법
 * 1) static final int[] dx, dy 배열에 대각선을 포함한 상하좌우 총 8개의 방향을 입력한다.
 * 2) Land라는 클래스를 만들어 섬의 좌표를 x,y를 멤버로 한다.
 * 3) Land 객체를 담을 큐를 선언하고, BFS로 섬을 찾는다.
 * 4) 연결요소를 찾는 것이기 때문에 main의 for문 안에서 방문하지 않은 모든 섬을 탐색해야 한다.
 * 5) while의 종료는 w와 h가 모두 0일 때 이므로 종료 조건문을 작성한다.
 * 
 */
class Land{//섬의 좌표를 저장할 객체
	int x;
	int y;
	Land(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class P4963 {
	static final int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
	static final int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};
	
	static int[][] map;
	static int[][] cache;
	
	static void bfs(int xs, int ys, int cnt){
		Queue<Land> q = new LinkedList<Land>();
		q.add(new Land(xs,ys));
		
		while(!q.isEmpty()){
			Land popped = q.poll();
			
			int x = popped.x;
			int y = popped.y;
			
			for(int i = 0; i<8;i++){
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length){
					if(map[nx][ny] == 1 && cache[nx][ny] == 0){
						cache[nx][ny] = cnt;
						q.add(new Land(nx,ny));//연결된 섬을 큐에 삽입
					}
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			int cnt = 0;
			
			if(w == 0 && h == 0){// 종료 조건문
				break;
			}
			map = new int[h][w];
			cache = new int[h][w];
			
			for(int i = 0; i<map.length;i++){
				for(int j = 0; j<map[i].length;j++){
					map[i][j] = sc.nextInt();
				}
			}
			
			//연결요소 찾기!!!
			for(int i = 0;i<map.length;i++){
				for(int j = 0; j<map[i].length;j++){
					if(map[i][j] == 1 && cache[i][j] ==0){//섬인지 확인후, 방문여부 확인!
						cnt++;
						bfs(i,j,cnt);
					}
				}
			}
			System.out.println(cnt);
		}
		
	}

}
