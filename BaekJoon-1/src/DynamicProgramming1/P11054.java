package DynamicProgramming1;

import java.util.Scanner;

/* 가장 긴 바이토닉 부분 수열
 * 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
 * 예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,
 * {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
 * 수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) 배열의 인덱스 0부터 증가하는 부분 수열의 최대 길이를 d배열에 저장
 * 2) 배열의 인덱스 n-1번째부터 num[i] 보다 작은 num[j]중에 d2[j]의 최대값을 찾아 +1 한다.
 * 3) 두 배열을 각각 인덱스끼리 더해준다 . d[i]+d2[i] 이렇게
 * 4) 더한 값중에 최댓값을 찾고 -1을 해준다. 증가하는 수열과 감소하는 수열중 가장 큰 수 1개가 중복되기 때문에!
 * 주의★ 감소하는 수열의 길이를 구할 때 n-1에서부터 시작을 안하고 0부터 시작해서 풀면 나중에 더했을때 제대로된 바이토닉 길이의 값을 구할 수 없다.
 */
public class P11054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] num = new int[n];
		int[] d = new int[n]; //증가하는 부분 수열을 찾기위한 배열 (LIS)
		int[] d2 = new int[n]; // 감소하는 부분 수열을 찾기위한 배열
		
		for(int i = 0; i<n;i++){
			num[i] = sc.nextInt();
		}
		
		for(int i = 0; i<n;i++){
			d[i] = 1;
			for(int j = 0;j<i;j++){
				if(num[i]>num[j] && d[i] < d[j]+1){
					d[i] = d[j]+1;
				}
			}
		}
		//가장 길게 감소하는 수열 길이 구하기
		for(int i = n-1;i>=0;i--){
			d2[i] = 1;
			for(int j = i+1;j<n;j++){
				if(num[i]>num[j] && d2[i] <d2[j]+1){
					d2[i] = d2[j]+1;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i<n;i++){
			if(ans < d[i]+d2[i]-1) // -1 하는 이유는 가장 큰 수(i번째 수)가 중복되기 때문
				ans = d[i]+d2[i]-1;
		}
		
		System.out.println(ans);
	}
}
