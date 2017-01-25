package DataStructure1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 조세퍼스 문제 (큐 강의 예제)- 수업듣기 전 내가 먼저 문제 풀어본거!!!!
 * 접근방법
 * 1)연결리스트를 만들어 m번째 수를 삭제하고 다시 m번째를 찾아 삭제한다. 연결리스트 size가 0일때까지
 * 2)index를 계산할때 연결리스트 size를 넘을때 예외처리를 해줌. begin = begin%linked.size();
 */
public class P1158_byMyself {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		LinkedList<Integer> linked = new LinkedList<Integer>();
		Queue<Integer> ans = new LinkedList<Integer>();
		
		for(int i = 1; i<=n;i++){
			linked.add(i);
		}
		int begin=0;
		while(!linked.isEmpty()){
			begin +=(m-1);
			if(begin >= linked.size()){
				begin = begin%linked.size();
			}
			ans.add(linked.get(begin));
			linked.remove(begin);
			
		}
		System.out.print("<");
		/*for(int i = 1; i<ans.size();i++){ // 이렇게 하지말자!!!!!!!! size는 for문 돌때마다 바뀜
			System.out.print(ans.poll()+", ");
		}*/
		while(ans.size()!=1){
			System.out.print(ans.poll()+", ");
		}
		System.out.print(ans.poll()+">");
		
	}
}
