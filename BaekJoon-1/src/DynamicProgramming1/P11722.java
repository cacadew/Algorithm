package DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;
/* 가장 긴 감소하는 부분 순열
 * 수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.
 * 예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우
 * 가장 긴 감소하는 부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3이다.
 * 
 * 접근방법 - P11053[LIS] 문제 참고
 * 1) LIS를 바탕으로 두가지의 접근방법이 있다.
 * 2) 첫번째, 입력으로 주어진 수열A를 뒤집어서 가장 긴 증가하는 부분 수열을 구하는 방법 (뒤집어서 LIS)
 * 3) 두번째, 가장 긴 증가하는 부분 수열과 비슷하게 구하는 방법 (내가 푼 방식)
 * 4) 두번째 방식으로 풀때, for문 안의 if문 조건을 num[j]>num[i]로 해주면 된다!
 */

public class P11722 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int[] num = new int[size];
		int[] d = new int[size];
		
		for(int i = 0; i<size;i++){
			num[i] = sc.nextInt();
		}
		
		for(int i = 0;i<size;i++){
			d[i] = 1;
			for(int j = 0;j<i;j++){
				if(num[j]>num[i] && d[i] < d[j]+1){ //LIS와 조건이 다름!!! 
					d[i] = d[j]+1;
				}
			}
		}
		Arrays.sort(d);
		System.out.println(d[size-1]);
	}
}
