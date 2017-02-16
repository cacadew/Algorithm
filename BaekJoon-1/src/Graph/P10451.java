package Graph;

import java.util.Scanner;
/* 순열 사이클
 * 각 정점이 하나의 out-edge만 가질 때, 각 배열의 index는 자기 자신 정점. 배열 값은 연결된 정점이다.
 * 순열사이클이 몇개 있는지 구해라! 사이클은 연결요소처럼 분리되어있음.
 * 
 * 접근방법
 * 1) 간선이 하나씩만 있으니까 인접행렬, 인접리스트는 비효율적이다. 1차원 배열이 적합
 * 2) 연결요소의 개수 구했던 문제와 똑같이 접근하면 된다.
 * 3) for문으로 방문하지 않은 정점부터 dfs탐색을 하면 된다.
 * 4) dfs에서 방문여부 체크 후 for문으로 다음 정점을 찾는 과정 대신, 바로 해당 정점을 인덱스로 갖는 배열값으로 재귀호출을 하면된다.
 * 5) 재귀 대신 while문으로도 가능하다 (밑에 주석 참고)
 * 
 */
public class P10451 {
	static int[] map;
	static boolean[] check;
	
	static void dfs(int s){
		
		//재귀를 통해 구하는 방법
		check[s] = true;
		if(check[map[s]] == false)
			dfs(map[s]);//이어지는 정점으로 다시 dfs호출
		
		//while문을 사용해서 구하는 방법
		/*while(check[s] == false){//방문여부 확인 -> 사이클 완성되면 종료해야하니까
			check[s] = true; // 방문여부 변경
			s = map[s];// 이어지는 정점을 다시 변수 s에 저장해서 while문 돌기
		}*/
			
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		while(tc-->0){
			int vNum = sc.nextInt();
			map = new int[vNum+1];
			check = new boolean[vNum+1];
			
			for(int i = 1;i<map.length;i++){
				map[i] = sc.nextInt();
			}
			
			
			int cnt=0;
			for(int i = 1;i<map.length;i++){
				if(check[i] == false){
					dfs(i);
					cnt++;
				}
				
			}
			
			System.out.println(cnt);
			
			
		}
	}
}
