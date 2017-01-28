package DynamicProgramming1;

import java.util.Scanner;

/* 1,2,3 더하기 문제
 * 
 * 정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) n번째 수를 1,2,3 조합으로 나타낼 때 가장 마지막에 더해지는 수는 1 or 2 or 3 이다.
 * 2) 따라서 D[n]은 [마지막이 +1로 끝나는 경우] + [마지막이 +2로 끝나는 경우] + [마지마깅 +3 으로 끝나는 경우] 이다.
 * 3) 점화식으로 하면 D[n] = D[n-1]+D[n-2]+D[n-3];
 */
public class P9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		while(tc-->0){
			int num = sc.nextInt();
			
			int[] d = new int[11];//0으로 다 초기화
			d[0] = 1;
			
			for(int i = 1;i<4;i++){// d[1],d[2]는 i-3 하면 인덱스가 0 이하가 되므로 따로 for문과 if문을 사용
				for(int j = 1;j<4;j++){
					if(i-j >=0)
						d[i] += d[i-j];
				}
			}
			
			for(int i = 4;i<11;i++){
				d[i] = d[i-1]+d[i-2]+d[i-3];
			}
			
			System.out.println(d[num]);
		}
		
		
	}
}
