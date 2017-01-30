package DynamicProgramming1;

import java.util.Scanner;

/*붕어빵 판매하기 - 나혼자 풀어본것.
 * 1개를 팔 때 가격, 2개를 팔 태 세트 가격, 3개를 팔 때 세트가격 ... 이 주 어질 때 n개를 판매하는데 얻을 수 있는 최대 수익을 구하시오.
 * 
 * 접근방법
 * 1) Top-down 방식으로 풀었음. (보통 topdown은 재귀호출을 이용할 때가 많음)
 * 2) 백준은  D[i-j]+A[j] 이렇게 푼거고 나는 D[i-j]+D[j] 이렇게 풀었음.
 * 어렵게 접근하지 말고! 단순화해서 제일 마지막 경우를 생각해서 점화식 도출하기!!!!!
 */
public class P11052 {
	static int[] cache;// cache[i] = 붕어빵 i개를 살 때 가장 큰 수익 . ex) cache[2]는 붕어빵 2개를 살때의 가장 큰 수익
	static int[] coin;// scanner로 입력받은 i개를 팔 때의 세트가격  ex) coin[2] = 5 이면, 2개를 팔때 붕어빵 세트의 가격
	
	static int find(int n){
		if(n == 1)
			return cache[1];
		else if(cache[n] != 0)
			return cache[n];
		
		else{
			for(int i = 1; i<n/2+1;i++){
				int temp = Math.max(coin[n], find(n-i) + find(i));
				if(temp>cache[n])
					cache[n] = temp;
			}
			
			return cache[n];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		coin = new int[n+1];
		cache = new int[n+1];
		
		for(int i = 1;i<=n;i++){
			coin[i] = sc.nextInt();
		}
		cache[1] = coin[1];
		
		System.out.println(find(n));
		
		
	}
}
