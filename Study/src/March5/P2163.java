package March5;

import java.util.Scanner;
/* 초콜릿 자르기
 * 정화는 N×M 크기의 초콜릿을 하나 가지고 있다. 초콜릿은 금이 가 있는 모양을 하고 있으며, 초콜릿을 계속 쪼개서 총 N×M개의 조각으로 쪼개려고 한다.
 * 초콜릿을 쪼갤 때에는 초콜릿 조각을 하나 들고, 적당한 위치에서 초콜릿을 쪼갠다. 이와 같이 초콜릿을 쪼개면 초콜릿은 두 개의 조각으로 나눠지게 된다.
 * 이제 다시 이 중에서 초콜릿 조각을 하나 들고, 쪼개는 과정을 반복하면 된다.
 * 초콜릿의 크기가 주어졌을 때, 이를 1×1 크기의 초콜릿으로 쪼개기 위한 최소 쪼개기 횟수를 구하는 프로그램을 작성하시오.
 * 
 * 접근방법 (처음에 DP로 접근하여 점화식을 구하다가 식 하나로 정리됨을 알 수 있었음)
 * 1) N == 1일때, 1*M 크기의 초콜릿을 자르는 횟수는 M-1 이다.
 * 2) N==2일때, 1*M크기의 초콜릿을 자르는 횟수에서 M만큼을 더해주면 된다. => (M-1)+M
 * 3) 따라서, N*M 크기의 초콜릿을 자르는 횟수는 M*N-1이 된다.
 */
public class P2163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println(n*m-1);
		
		
	}
}