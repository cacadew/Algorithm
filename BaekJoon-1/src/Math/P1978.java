package Math;

import java.util.Scanner;
/* 소수찾기
 * 주어진 숫자들 중 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) 2 ~ 루트n 까지의 수로 나눴을 때, 나누어 떨어지지 않으면 소수이다!
 * 2) 그 이유는 n = a*b 일때, a의 범위가 2보다 크고 루트n보다 작을 때 b는 a의 값에 따라 루트n보다 큰 n의 약수를 가지기 때문이다.
 * 3) 소수의 정의가 1과 자기 자신으로만 나눠지는 수 이기 때문에, n의 값이 2이하일때 예외처리 필요
 */
public class P1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();//테스트케이스(입력되는 숫자 갯수)
		
		int ans = 0;// 소수일때마다 +1해서 while문 다 돌고 출력
		while(tc-->0){
			int n = sc.nextInt();//소수인지 판별하려는 숫자
			
			if(n <2)//2보다 작을 경우 소수가 아니므로 continue
				continue;
			
			boolean b = true; // 2~루트n 까지 나눴을 때, 나누어 떨어지면 false, 아니면 true
			for(int i = 2; i*i <=n;i++){//★ 루트n을 Math.sqrt()로 사용하면 소수이므로 번거롭기 때문에 i*i<n 조건을 주면 편함!!!!
				if(n%i == 0){
					b = false;//나누어떨어지므로 소수가 이니니까 b를 false로 변경
					break;//for문을 나온다.
				}
			}
			if(b== true)//b가 그대로 true이면 나누어 떨어지는 수가 없다는 뜻이므로 소수니까 ans 1증가
				ans++;
		}
		
		System.out.println(ans);
	}
}
