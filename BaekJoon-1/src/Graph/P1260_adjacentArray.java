package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* DFS와 BFS - 인접배열 풀이과정
 * 
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 * 첫 째 줄에는 정점의 개수(N), 간선의 개수(M), 탐색을 시작할 정점의 번호(V)가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 한 간선이 여러 번 주어질 수도 있는데, 간선이 하나만 있는 것으로 생각하면 된다. 입력으로 주어지는 간선은 양방향이다.
 * 
 * 접근방법
 * 1) DFS의 경우 재귀함수를 이용
 * 1-1) 간선이 없는 경우 배열 값이 0이기 때문에 0이 아닌지 확인하고, check[]을 통해 방문여부를 확인해야한다.
 * 
 * 2) BFS의 경우 Queue를 이용
 * 2-2) 큐가 비어있지 않은지 확인한 후, q에서 pop을 한다.
 * 2-3) pop된 변수가 i라면, map[i][]를 모두 돌면서 인접해있는 모든 정점을 다시 큐에 넣고 while문을 돌면서 탐색한다.
 * 2-4) 주의해야 할 점은! check[]= true;를 넣은 후에 q에 넣는것! 실수 줄이기
 */

public class P1260_adjacentArray {
	static boolean[] check; //방문여부를 저장. 방문 :true, 방문x:false
	static int[][] map; //그래프를 저장
	static Queue<Integer> q = new LinkedList<Integer>();//BFS에서 사용할 큐
	
	//DFS
	static void dfs(int start){
		check[start] = true; // 방문표시
		System.out.print(start+" ");
		
		for(int i = 1; i<map.length;i++){
			if(map[start][i] == 1 && check[i] == false){//start 정점과 인접한 정점이 방문여부가 있는지 확인! 없을경우 if문 통과
				dfs(i);//인접한 정점을 가지고 다시 dfs 재귀
			}
		}
		
	}
	//BFS
	static void bfs(int start){
		while(!q.isEmpty()){//큐가 비어있지 않은지 먼저 확인!
			int v = q.poll();//큐의 front를 pop
			System.out.print(v+" ");
			
			for(int i = 1; i<map.length;i++){
				if(map[v][i] == 1 && check[i] == false){//start 정점과 인접한 정점이 방문여부가 있는지 확인, 없을경우 if문 통과
					check[i] = true;// check[]에 먼저 방문여부를 true로 변경 후 큐에 요소 push
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vNum = sc.nextInt();//정점 개수
		int eNum = sc.nextInt();//간선 개수
		int start = sc.nextInt();//시작 정점
		
		map = new int[vNum+1][vNum+1];
		check = new boolean[vNum+1];
		
		for(int i = 0; i<eNum;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = map[y][x] = 1;//무방향(양방향)그래프이므로 두번 입력
		}
		
		dfs(start);
		System.out.println();
		for(int i = 0;i<check.length;i++)//bfs에 check[]를 다시 사용하기 위해 초기화
			check[i] = false;
		
		check[start] = true;//시작 정점 start 정점의 방문여부 true로 변경
		q.add(start);//큐에 시작정점 add
		bfs(start);
	}
}
