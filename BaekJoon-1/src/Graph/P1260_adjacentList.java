package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/* DFS와 BFS - 인접리스트 풀이과정
 * 
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 * 첫 째 줄에는 정점의 개수(N), 간선의 개수(M), 탐색을 시작할 정점의 번호(V)가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 한 간선이 여러 번 주어질 수도 있는데, 간선이 하나만 있는 것으로 생각하면 된다. 입력으로 주어지는 간선은 양방향이다.
 * 
 * 접근방법
 * 1)인접리스트 선언 및 생성 
 * 1-1) ArrayList<Integer>[] arr 배열을 정점의 개수만큼의 크기로 만든다 ->각 배열의 요소에 ArrayList를 저장하는 배열임
 * 1-2) 생성 : arr = (ArrayList<Integer>[])new ArrayList[정점개수+1];
 * 1-3) for문으로 정점의 개수만큼 돌면서, arr[i] = new ArrayList<Integer>(); 하면 각 arr의 인덱스마다 ArrayList가 생성된다.
 * 
 * 주의★ 주의해야할 점은 문제에서 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문한다고 되어있다. 따라서 각 ArrayList를 오름차순 정렬해야한다.
 * 이 문제에서는 DFS를 먼저하니까 dfs()에서 각 정점을 방문할 때마다 sort를 해줬는데, 메소드 방문 전 미리 sort를 해도된다.
 * 
 * 2)DFS, BFS
 * 2-1) 인접배열과 방식은 동일하게 재귀를 이용한다.
 * 2-2) 인접리스트에는 오로지 연결된 정점만을 가지고 있기 때문에 간선의 유무를 생각할 필요가 없다.
 * 
 */
public class P1260_adjacentList {
	static boolean[] check;//방문여부를 검사할 배열
	static ArrayList<Integer>[] arr;//ArrayList를 담을 배열 = 인접리스트
	
	static Queue<Integer> q = new LinkedList<Integer>();//BFS에 사용될 큐
	
	//DFS
	static void dfs(int s){
		check[s] = true;
		Collections.sort(arr[s]);// 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문해야하므로 오름차순으로 정렬!!!!
		System.out.print(s+" ");
		for(int i=0;i<arr[s].size();i++){//해당 정점의 ArrayList 요소를 탐색
			int v = arr[s].get(i);
			if(check[v] == false)
				dfs(v);
		}
	}
	
	//BFS
	static void bfs(int s){
		while(!q.isEmpty()){
			int popped = q.poll();
			System.out.print(popped+" ");
			for(int i = 0;i<arr[popped].size();i++){
				int v = arr[popped].get(i);
				
				if(check[v] == false){
					check[v] = true;
					q.add(v);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vNum = sc.nextInt();//정점개수
		int eNum = sc.nextInt();//간선개수
		int s = sc.nextInt();//시작점
		
		arr = (ArrayList<Integer>[])new ArrayList[vNum+1];//ArrayList를 저장할 배열의 크기를 정점의 개수+1로 생성한다.
		check = new boolean[vNum+1];
		
		for(int i = 1;i<=vNum;i++){
			arr[i] = new ArrayList<Integer>();//arr의 각 인덱스마다 ArrayList 생성
		}
		
		for(int i = 1; i<=eNum;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			arr[x].add(y);//각 인덱스의 ArrayList에 추가
			arr[y].add(x);
		}
		
		dfs(s);
		System.out.println();
		
		for(int i = 0; i<check.length;i++)//BFS에서도 방문여부를 알기위해 check[]를 초기화한다.
			check[i] = false;
		
		check[s] = true;//시작정점을 check[]에 방문여부 true로 변경 후, q에 push
		q.add(s);
		bfs(s);
	}
}
