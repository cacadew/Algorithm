package DynamicProgramming1;

import java.util.Scanner;
/* 쉬운 계단 수 문제
 * 45656이란 수를 보자. 이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.
 * N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)
 * 
 * 접근방법
 * 1) 2차원배열 d[n+1][10]을 만든다. d[i][j]에는 n의 자릿수의 가장 마지막 1의자리에서  숫자 j가 몇번 나오는지가 저장된다.
 * 2) d[1]행의 경우 한 자릿 수 숫자에는 0은 불가하고 1~9까지 가능하므로 0을 제외하고 모두 1을 넣어준다.
 * 3) d[2]이상 부터, d[i][j]는  d[i-1][j-1]와 d[i-1][j+1]의 의해서 d[i][j]가 발생하기 때문에  d[i][j]=  d[i-1][j-1] + d[i-1][j+1] 라는 점화식을 구할 수 있다.
 * 4) 대신, d[i][0]의 경우와 d[i][9]의 경우 각각 1에 의해서 8에 의해서만 발생되기 때문에 j-1과 j+1에 대한 예외처리가 필요하다.
 * 5) 문제에서 1,000,000,000으로 나눈 나머지를 출력하라고 했다. 이 수의 범위를 저장하려면 long 타입으로 변수를 선언해야하고, 배열 d도 long 타입, 답을 출력하는 ans변수도 long 타입으로 선언해야한다.
 */

public class P10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long mod = 1000000000L;
		int n = sc.nextInt();
		
		long[][] d = new long[n+1][10];
		
		for(int i = 1;i<10;i++){ //한 자리 수에는 0은 못오니까 제외
			d[1][i] = 1;
		}
		
		for(int i = 2;i<=n;i++){
			for(int j = 0;j<10;j++){
				d[i][j] = 0;
				if(j-1>=0){
					d[i][j] +=d[i-1][j-1];
				}
				if(j+1<=9){
					d[i][j] += d[i-1][j+1];
				}
				
				d[i][j] %= mod;
			}
		}
		long ans=0;
		for(int i= 0; i<10;i++){
			ans += d[n][i];
		}
		System.out.println(ans%=mod);
		
		
	}
}
