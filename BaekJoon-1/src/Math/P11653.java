package Math;

import java.util.Scanner;
/* 소인수 분해
 * 정수 N을 소수의 곱으로 분해한다.
 * 
 * 접근방법
 * 1) 2부터 루트 n까지 for문을 돈다. n=a*b일 때, a나 b 중 둘중 하나는 루트n보다 작기 때문에 루트n까지만 반복문을 돈다.
 * 2) for문안에 while문을 넣어 n이 i로 나누어 떨어질때마다 i를 출력하고 n에는 나눈 몫을 넣어준다.
 * 3) for문을 다 돌고 마지막 남은 수까지 if문을 통해 출력한다!
 * 
입력 : 72 출력 : 2 2 2 3 3
입력 : 9991 출력 : 97 103
 */
public class P11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 2;i*i<=n;i++){//n=a*b일때, 둘중 하나는 루트n보다 작다.
			while(n%i == 0){
				System.out.println(i);
				n /= i;
			}
		}
		if(n > 1)//마지막 남은 n까지 출력!
			System.out.println(n);
	}
}
