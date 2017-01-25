package DataStructure1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 조세퍼스 문제 - 백준 풀이과정 듣고 한거
 * 
 * 접근방법
 * 1) Queue에 1~n 까지를 모두 넣은 후 , n번째 일때만 pop 하고 출력! 나머지는 pop해서 다시 push
 * 
 */
public class P1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i<=n;i++){
			q.add(i);
		}//q에 1부터 n까지 숫자 push
		
		System.out.print("<");
		while(!q.isEmpty()){
			for(int i = 0; i<m;i++){
				if(i == m-1){
					System.out.print(q.poll());
				}
				else{
					q.add(q.poll());
				}
			}
			if(!q.isEmpty())
				System.out.print(", ");
			else
				System.out.print(">");
		}
	}
}
