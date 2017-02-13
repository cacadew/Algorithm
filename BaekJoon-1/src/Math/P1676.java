package Math;

import java.util.Scanner;
/* 팩토리얼 0의 개수 - n!에서 0이 몇개 있는지 찾는 문제 - 2*5 가 몇개인지 찾기!!!
 * 
 * 접근방법
 * 1) 0이 나오려면 소인수분해를 했을 때 (2*5)가 됐을 때 이다.
 * 2) 따라서 (2*5)의 갯수를 구해주면 된다.
 * 3) 여기서 2는 항상 5보다 갯수가 더 많다. 따라서 5가 몇번 나오는지만 구해주면 된다.
 * 4) 5로 나누어 떨어지는 수의 갯수 + 5의 제곱 수는 5가 더 들어가기 때문에  n/5 + n/25 + n/125 를 해줘야 한다.
 * 5) 이 문제에서 n의 범위가 500 이하라서 n/125까지만 해줬는데, 더 큰 수일 경우에는 625까지 계속 해줘야함..(for나 while을 써서 하는게 더 좋을수도!)
 *  
 */
public class P1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(n/5 + n/25 + n/75);
	}
}
