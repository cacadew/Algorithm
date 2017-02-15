package Graph;

import java.util.ArrayList;
import java.util.Scanner;

/* 연결 요소의 개수
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) dfs()를 몇번 실행하는 지를 구하면 된다.
 * 2) for문안에서 dfs(i)를 실행한다. 연결된 요소를 한번 돌았으니 cnt++
 * 3) 그리고 그 1 증가한 i가 check[i]==false 라면, 다시 dfs를 실행하고 cnt++;
 * 4) 한번 dfs를 실행할 때 연결되어 있지 않은 요소들은 check[]에 여전히 false로 남아있기 때문에 이 점을 활용해서 연결요소의 개수를 세면 된다.
 * 
 */
public class P11724 {
	static ArrayList<Integer>[] arr; //인접리스트로 정점과 간선 저장
	static boolean[] check; // 방문여부를 체크하기 위한 배열
	static int cnt=0; //연결요소 개수! dfs를 몇번 실행했느냐를 count한다.
	
	static void dfs(int s){
		check[s] = true;//방문되었으므로 true로 변경
		
		for(int i = 0;i<arr[s].size();i++){
			int temp = arr[s].get(i);
			if(check[temp] == false)
				dfs(temp);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vNum = sc.nextInt();
		int eNum = sc.nextInt();
		
		arr = (ArrayList<Integer>[])new ArrayList[vNum+1];
		check = new boolean[vNum+1];
		
		for(int i = 1; i<=vNum;i++){
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i<=eNum;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			arr[x].add(y);
			arr[y].add(x);
			
		}
		
		for(int i = 1; i<=vNum;i++){// i 정점부터 탐색 시작
			if(check[i] == false){ // i가 방문되지 않았다면 if문 실행
				dfs(i);
				cnt++; // dfs를 한번 실행하면 재귀를 통해 연결된 모든 점을 순회하고 온다. 따라서 연결요소를 순회하고 온것이므로 cnt의 값을 1 증가한다.
			}
		}
		System.out.println(cnt);
		
	}
}
