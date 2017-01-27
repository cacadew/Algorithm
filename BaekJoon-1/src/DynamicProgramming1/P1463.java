package DynamicProgramming1;

import java.util.Scanner;

/* 1로 만들기
 * 
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최소값을 출력하시오.
 * 
 * 접근방법
 * 1) memo[]에 각 숫자가 1로 만들어지는데 필요한 연산의 최솟값을 저장한다.
 * 2) memo[num/3], memo[num/2], memo[num-1] 의 최솟값에 +1을 더하여 memo[num]에 저장한다.
 * 
 */
public class P1463 {
	static int[] memo;
	
	static int find(int num){
		if(num == 1)//num이  1이면 return 0
			return 0;
		
		int min = 100;
		if(memo[num]==-1){//아직 한번도 계산되지 않은 수
			if(num % 3 == 0){
				min = Math.min(find(num/3)+1, min);
			}
			if(num % 2 == 0){
				min = Math.min(find(num/2)+1, min);
			}
			if(num != 1){
				min = Math.min(find(num-1)+1, min);
			}
			
			memo[num] = min;
			return min;
		}
		else//이전에 계산되어 이미 memo[num] 값이 존재하는 경우 그대로 return
			return memo[num];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		memo = new int[num+1];
		for(int i = 0; i<=num;i++)
			memo[i] = -1;
		memo[0] = memo[1] = 0;
		
		int result = find(num);
		System.out.println(result);
		
	}
}
