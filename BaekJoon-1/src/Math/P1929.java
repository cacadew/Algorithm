package Math;

import java.util.Scanner;
/* 소수 구하기 - 에라토스테네스의 체
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1≤M≤N≤1,000,000)
 * 
 * 접근방법
 * 1) boolean 타입의 배열을 n개 만들고, 나누어 떨어지면 true로 변경!(boolean 타입 초기화는 false)
 * 2) check[i] == false 일때, false의 배수들을 다 지운다.
 * 3) 주의해야할 점은 지워나갈때 j= i*i 부터 하게되면, j가 int로 표현 안될 수 있으므로 안전하게 j = i+i 부터 시작한다!!
 */
public class P1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		boolean[] check = new boolean[n+1];
		check[0] = check[1] = true;// 0과 1은 소수가 아님
		
		for(int i = 2;i<n;i++){
			if(check[i] == false){//아직 지워지지 않은 수임을 확인한 후 배수를 지운다.
				for(int j = i+i;j<=n;j+=i){//접근방법 3에서 말한 주의사항. 이미 2 ~ i*i 전까지의 i의 배수들은 다 지워진 상태지만,
					check[j] = true; //자료형 범위를 생각해서 i+i부터 시작하는게 좋다.
				}
			}
		}
		for(int i = m;i<=n;i++){
			if(check[i] == false){//지워지지 않은 것의 index를 출력! index가 해당 숫자니까!
				System.out.println(i);
			}
		}
	}
}
