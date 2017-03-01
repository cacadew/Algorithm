package Greedy;

import java.util.Scanner;
/* 대회 or 인턴
 * 대회에 팀을 이루려면 여학생 2명, 남학생 1명이 필요하다.
 * 그런데 대회에 참여하는 학생들 중 K명을 반드시 인턴쉽 프로그램에 참여시켜야 한다.
 * N명의 여학생과 M명의 남학생, K명의 인턴쉽에 참여해야하는 인원이 주어질 때, 만들 수 있는 최대의 팀 수를 구해라.
 * 
 * 접근방법
 * 1)N+M >= K+3 이다.
 * 1-1) 여학생이 2명, 남학생이 1명만 있을 때, 인턴을 보내야하는 인원이 1명이상일 때 한 팀도 결성될 수가 없다.
 * 1-2) 따라서 K가 1일 때는 M+N이 4이상이여야지 팀이 결성될 수 있다. 때문에 M+N>=K+3이 성립한다.
 * 2) while문을 돌면서 N이 2 이상이고, M이 1 이상이고, M+N>=K+3일때 팀 수를 1씩 증가한다.
 * 3) while문 안을 수행할 때 N은 2씩 감소하고 M은 1씩 감소한다.
 */
public class P2875 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.next());//여자 학생 수
		int m = Integer.parseInt(sc.next());//남자 학생 수
		int k = Integer.parseInt(sc.next());//인턴 수
		
		int ans = 0;
		
		while(n>=2 && m>=1 && n+m>=k+3){
			n-=2;
			m-=1;
			ans++;
		}
		
		System.out.println(ans);
	}

}
