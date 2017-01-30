package DynamicProgramming1;

import java.util.Scanner;
/* 붕어빵 판매하기 - 백준 풀이과정듣고 다시 푼거
 * 
 * 접근방법
 * 1) 이 문제에서 D[i] = 붕어빵 i개를 팔아서 얻을 수 있는 최대 수익
 * 2) 마지막에 1개를 팔때 최대 수익을 구하려면 D[n-1]+A[1] 를 해주면 된다. 맨 마지막에 2개짜리 세트를 팔 때 최대 수익을 구하려면
 *    D[n-2]+A[2]를 해주면 된다.
 */
public class P11052_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] coin = new int[n+1];
		int[] d = new int[n+1];
		/*coin[0]= 0;
		d[0] = 0;*/ 
		//자동으로 0 초기화 됨
		
		for(int i = 1;i<coin.length;i++)//세트 가격 입력받음
			coin[i] = sc.nextInt();
		
		for(int i = 1; i<coin.length;i++){// i개 구입시 최대 수익은 j개 샀을때와 i-j개 샀을때의 최대수익을 더해줘서 max값을 찾으면 된다.
			for(int j = 1;j<=i;j++){	  // i==j가 같아지면 i개를 한꺼번에 샀을때의 금액까지 비교 가능
				d[i] = Math.max(d[i], d[i-j]+coin[j]);
			}
		}
		System.out.println(d[n]);
	}
}
