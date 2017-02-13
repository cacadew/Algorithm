package Math;

import java.util.Scanner;
/* 조합 0의 개수 - nCm의 0의 개수 구하기
 * 첫째 줄에 정수 n, m(0≤m≤n≤2,000,000,000, n!=0)이 들어온다.
 * 
 * 접근방법 - 백준 풀이과정(P2004_2)보면, for문을 사용해서 수의 크기까지의 2와 5의 거듭제곱을 하고 있음. 훨씬 간단!!
 * 1) nCm = n! / m!(n-m)! 이다.(n<m)
 * 2) 0은(2*5)일때만 나타나므로, 각 분모 분자에서의 (2*5) 갯수를 찾아주면 된다.
 * 3) 분수이기 때문에 문자의 0의 갯수에서 분모의 0의 갯수를 빼줘야 한다.
 * 4) 또한 팩토리얼 문제와 다르게, 약분할 때 2의 갯수가 5의 갯수보다 적어질 수 있으므로 2와 5의 갯수를 모두 구해야한다.
 */
public class P2004 {
	
	static int count(int num, int b, int cnt){ //  num :입력받은 수 , b :2또는 5, cnt :num에서의 2or5의 갯수를 저장할 변수	
		long temp = b; //temp가 long형인 이유는, num이 2000000000일 때, temp가 누적되면서 결국 int의 범위를 넘어가기 때문!
		while(num >=temp ){ //num이 b의 몇 제곱 이상까지 큰지 모르기 때문에, temp에 b를 곱해가며 while문을 돈다.
			cnt = cnt + (int)(num/temp);
			temp = temp*b;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int down_cnt2 = 0, down_cnt5 = 0;//분모의 2와 5의 갯수를 저장할 변수
		int up_cnt2 = 0, up_cnt5 = 0; //분자의 2와 5의 갯수를 저장할 변수
		int ans2 = 0, ans5 = 0; // (약분 후) nCm에서의 2와 5의 갯수를 저장할 변수 
		
		down_cnt2 = count(m,2,down_cnt2);// 분모 m!에서의 2의 갯수 구하기
		down_cnt5 = count(m,5,down_cnt5);// 분모 m!에서의 5의 갯수 구하기
		down_cnt2 = count(n-m,2,down_cnt2);// 분모 (m-n)!에서의 2의 갯수 구하기
		down_cnt5 = count(n-m,5,down_cnt5);// 분모 (m-n)!에서의 5의 갯수 구하기
		//같은 변수에 누적해주는 이유는 곱셈을 할때, 지수(exponent)는 더해지기 때문!
		
		up_cnt2 = count(n,2,up_cnt2); // 분자 n!에서의 2의 갯수 구하기
		up_cnt5 = count(n,5,up_cnt5); // 분자 n!에서의 5의 갯수 구하기
		
		ans2 = up_cnt2-down_cnt2; // 2의 갯수 약분
		ans5 = up_cnt5-down_cnt5; //5의 갯수 약분
		
		if(ans2 < ans5)// 지수의 크기가 작은 것을 출력한다.
			System.out.println(ans2);
		else
			System.out.println(ans5);
	}
}




