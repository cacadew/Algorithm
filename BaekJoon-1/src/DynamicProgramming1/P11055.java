package DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 가장 큰 증가 부분 수열 - 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오
 * 
 * 접근방법 -P11053 참고 
 *
 */
public class P11055 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int[] num = new int[size];
		int[] d = new int[size];
		
		for(int i = 0; i<size;i++){
			num[i] = sc.nextInt();
		}
		
		for(int i = 0;i<size;i++){
			d[i] = num[i];
			for(int j =0;j<i;j++){
				if(num[j]<num[i] && d[i] < d[j]+num[i]){
					d[i] = d[j]+num[i];
				}
			}
		}
		Arrays.sort(d);
		System.out.println(d[size-1]);
	}
}
