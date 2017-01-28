package DynamicProgramming1;

import java.util.Scanner;

/*붕어빵 판매하기
 * 1개를 팔 때 가격, 2개를 팔 태 세트 가격, 3개를 팔 때 세트가격 ... 이 주 어질 때 n개를 판매하는데 얻을 수 있는 최대 수익을 구하시오.
 * 
 * 접근방법
 * 1) 이 문제에서 D[i] = 붕어빵 i개를 팔아서 얻을 수 있는 최대 수익
 * 2) 맨 마지막에 1개를 팔때 최대 수익을 구하려면 D[n-1]+A[1] 를 해주면 된다. 맨 마지막에 2개짜리 세트를 팔 때 최대 수익을 구하려면
 *    D[n-2]+A[2]를 해주면 된다.
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
