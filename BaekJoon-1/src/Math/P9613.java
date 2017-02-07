package Math;

import java.util.Scanner;
/*GCD 합
 * 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
 * 첫째 줄에 테스트 케이스의 개수 t (1 < t < 100)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고,
 * 첫째 줄에는 수의 개수 n (1 < n < 100)가 주어지고, 다음에는 n개의 수가 주어진다. 입력으로 주어지는 수는 1000000을 넘지 않는다.
 * 
 * 접근방법 - P2069 참고
 * 
예제 입력 : 
3
4 10 20 30 40
3 7 5 12
3 125 15 25

예제 출력 :
70
3
35
 */
public class P9613 {
	static int gcd(int a, int b){
		int r = a%b;
		if(r == 0){
			return b;
		}
		else{
			a = b;
			b = r;
			return gcd(a, b);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		while(tc-->0){
			int n = sc.nextInt();
			int[] num = new int[n];
			
			for(int i = 0;i<n;i++)
				num[i] = sc.nextInt();
			
			int gcdSum = 0;
			for(int i = 0; i<n-1;i++){
				for(int j = i+1;j<n;j++){
					gcdSum += gcd(num[i],num[j]);
				}
			}
			System.out.println(gcdSum);
		}
	}
}
