package Greedy;

import java.util.Scanner;

/* 동전 0
 * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
 * 동전을 적절히 사용해서 그 가치의 합을 K로 만드려고 한다. 이 때 필요한 동전 개수의 최소값을 구하는 프로그램을 작성하시오.
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 * 
 * 접근방법
 * 1) 이 문제의 접근방법은 다이나믹이 될 수 있고, 그리디 알고리즘이 될 수 있다.
 * 2) 주목해야 할 점은. 동전의 가치가 배수로 증가하고 있다는 것이다.
 *   동전의 가치가 이전 동전의 배수일 경우 그리디 알고리즘이 성립한다.
 * 3) 따라서 동전으 가치가 가장 큰 값부터 나누어 몫을 더하고, K원은 나머지(%)로 재정의한다.
 */
public class P11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int coinNum = Integer.parseInt(sc.next()); // 동전의 개수
		int amount = Integer.parseInt(sc.next()); // 구하려는 금액
		
		int[] coin = new int[coinNum];//동전 단위를 저장할 배열
		int cnt = 0;// 정답을 저장할 변수
		
		for(int i = 0; i<coinNum;i++){//배열에 동전의 종류 저장
			coin[i] = sc.nextInt();
		}
		
		for(int i = coinNum-1;i>=0;i--){//가장 큰 단위의 동전부터 시작
			cnt = cnt + amount / coin[i]; //나눈 몫이 해당 동전으로 지불할 수있는 개수 이므로 cnt에 누적시킨다.
			                              //coin[i]가 amount보다 크더라도 몫이 0이므로 상관없음
			
			amount = amount % coin[i]; //나머지 금액을 amount에 저장하여 다음 낮은단위의 동전으로 얼마나 낼수있는지를 계산한다.
		}
		
		System.out.println(cnt);
	}
}
