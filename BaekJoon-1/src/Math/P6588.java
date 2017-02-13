package Math;

import java.util.Scanner;
/* 골드바흐의 추측
 * "4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다."
 * 예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.
 * 이 추측은 아직도 해결되지 않은 문제이다.
 * 백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1)에네토스테네스의 체를 이용하여 모든 소수를 구한 후!!! while문으로 진입
 * 2)n = (n-i) + i 이므로, 홀수인 3부터 2씩 증가하며 n-i와 i가 모두 소수인지 확인한 후 출력한다.
 */
public class P6588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] check = new boolean[1000000];
		check[0] = check[1] = true;
		
		//에라토스테네스 체를 이용하여 1000000 이하의 소수를 구해놓는다.
		for(int i = 2;i<check.length;i++){
			if(check[i] == false){
				for(int j = i+i;j<check.length;j+=i){
					check[j] = true;
				}
			}
			if(i%2 == 0)
				check[i] = true;
		}
		
		while(true){
			int n = sc.nextInt();
			if(n == 0)//입력되는 n이 0이면 종료
				break;
			
			//n = (n-i) + i 이므로 n-i와 i가 소수인지 확인하면 된다.
			int index1=0, index2 = 0;
			for(int i = 3;i<=n;i+=2){//홀수인 3부터 시작 2씩증가
				if(check[n-i] == false && check[i] == false){
					index1 = i;
					index2 = n-i;
					break;
				}
			}
			if(index1 !=0)
				System.out.println(n+" = "+index1+" + "+index2);
			else
				System.out.println("Goldbach's conjecture is wrong.");
		}
	}
}
