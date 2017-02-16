package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/* 미로 탐색
 * N x M의 배열에서 1은 이동할 수 있는 칸이고, 0은 이동할 수 없는 칸이다.
 * (1,1)에서 출발하여 (N,M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하여라
 * 
 * 접근방법
 * 1) 가장 빠른 길을 찾는 문제는 DFS가 아니라!!! BFS 너비우선탑색을 해야한다.
 * 1-1) DFS일 때는 최단거리가 아닐 수가 있다. 따라서 그래프의 가중치가 모두 1일 때 최단거리는 BFS를 이용한다.
 * 2) Vertex 클래스가 이동할 수 있는 칸의 정보를 저장한다. 여기서 dist는 출발점에서부터의 거리이다.
 * 2-2) bfs()의 while문에서 인접한 Vertex를 큐에 넣을때, 현재의 dist값에서 1을 증가하여 저장한다.
 * 2-3) cache[]에는 출발점에서 현재 위치까지의 거리(dist)를 저장한다.
 * 2-4) 탐색이 끝난 후 cache[n-1][m-1]의 값을 출력하면, 도착점까지의 가장 빠른 길의 거리를 구할 수있다.
입력:
4 6
101111
101010
101011
111011

출력:
15
 */
class Vertex{
	int x;
	int y;
	int dist;//출발점으로부터의 거리
	
	Vertex(int x, int y, int dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
public class P2178 {
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, 1, -1};
	
	static int[][] map;
	static int[][] cache;
	
	
	static void bfs(){
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(new Vertex(0, 0, 1));
		
		while(!q.isEmpty()){
			Vertex popped = q.poll();
			
			int x = popped.x;
			int y = popped.y;
			int dist = popped.dist;//현재의 위치(출발점으로부터의 거리)
			
			for(int i = 0; i<4;i++){
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length){
					if(map[nx][ny] ==1 && cache[nx][ny] == 0){
						cache[nx][ny] = dist+1;//구하려값이 거리이기 때문에 cache에 거리를 저장
						q.add(new Vertex(nx, ny, dist+1));//항상 cache먼저 체크하고, q에 push
						//dist+1은 현재의 거리에서 한칸 더 나아가는 것이니까!
					}
				}
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		map = new int[n][m];
		cache = new int[n][m];
		
		for(int i = 0;i<n;i++){
			String line = sc.nextLine();
			for(int j = 0; j<m;j++){
				map[i][j] = line.charAt(j)-48;
			}
		}
		
		bfs();
		System.out.println(cache[n-1][m-1]);
	}
}
