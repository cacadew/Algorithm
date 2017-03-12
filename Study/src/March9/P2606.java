package March9;

import java.util.ArrayList;
import java.util.Scanner;
/* 바이러스
 * 컴퓨터 N대가 있는데 1번 컴퓨터가 바이러스에 감염되었고, 1번과 연결된 모든 컴퓨터는 바이러스에 감염된다.
 * 1번 컴퓨터를 통해 바이러스에 감염되는 컴퓨터의 수를 출력해라
 * 
 * 접근방법
 * 그래프 연결 요소 구하기문제와 같음(P11724)
 * 
 */
public class P2606 {
	static ArrayList<Integer>[] arr;
	static boolean[] check;
	
	static int dfs(int s, int cnt){
		check[s] = true;
		for(int i = 0; i<arr[s].size();i++){
			int temp = arr[s].get(i);
			if(check[temp]==false){
				cnt = dfs(temp,cnt+1);
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int comNum = sc.nextInt();
		arr = new ArrayList[comNum+1];
		check = new boolean[comNum+1];
		check[0] = true;
		
		for(int i = 1;i<arr.length;i++){
			arr[i] = new ArrayList<Integer>();
		}
		
		int eNum = sc.nextInt(); //간선개수 입력
		
		for(int i = 0; i<eNum;i++){
			int x = Integer.parseInt(sc.next());
			int y = Integer.parseInt(sc.next());
			
			arr[x].add(y);
			arr[y].add(x);
			
		}
		int cnt = dfs(1,0);
		System.out.println(cnt);
		
		
	}
}
