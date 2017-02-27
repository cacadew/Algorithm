package Greedy;

import java.util.Arrays;
import java.util.Scanner;

/* ATM
 * ATM이 1대밖에 없을 때 1~N까지의 사람들이 돈을 인출하는데 걸리는 시간의 합의 최소값을 구하여라
 * ex) 5명일 때 시간이 {3,1,4,3,2} 일 때, 3+(3+1)+(4+4)+(8+3)+(11+2) = 39
 * 만약 순서가 {1,2,3,3,4} 라면, 1+(1+2)+(3+3)+(6+3)+(9+4) = 32 이다.
 * 
 * 접근방법
 * 1) P가 서 있는 자리에서 돈을 인출하는 시간이다. P1=3,P2=1,P3=4,P4=3,P5=2 이런식으로
 * 2) 총합 S = n*P1 + (n-1)*P2 +(n-2)*P3 + +Pn
 * 3) 따라서 오름차순으로 정렬을 하면된다.
 * 4) 오름차순 후 이중for문을 이용하여 누적합을 구한다.
 * 
 */
public class P11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt(); // 사람의 수
		int ans = 0; //정답을 저장할 변수
		
		int[] arr = new int[size]; // 인출에 필요한 시간을 저장할 배열
		
		for(int i = 0; i<size;i++){
			arr[i] = Integer.parseInt(sc.next());
		}
		
		Arrays.sort(arr);//오름차순으로 정렬
		
		//i가 n일때, ans에는 arr[0] ~ arr[n]까지 모두 더해진다.
		for(int i = 0; i<size;i++){
			for(int j = 0; j <= i;j++){
				ans += arr[j];
			}
		}
		
		System.out.println(ans);
	}
}
