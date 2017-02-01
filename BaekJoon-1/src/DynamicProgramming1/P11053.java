package DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

/*가장 긴 증가하는 부분 수열 [LIS]
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 * 
 * 접근방법
 * 1) D[i] 는 A[i]를 마지막으로 하는 가장 긴 증가하는 부분 수열의 길이이다.
 * 2) 따라서, D[i] = D[j]+1;
 * 3) 이 점화식에서 j의 조건이 까다롭다. j<i // A[j]<A[i] 여야 한다.
 * 5) 앞에 자기 자신보다 작은 숫자가 없을 경우 D[i] = 1;
 * 4) D[i]는 처음 숫자부터 A[i-1]까지 for문을 돈다. 돌면서 A[i]보다 작은 수 중에 D[j]가 가장 큰 것에 +1을 해서 D[i]를 구하면 된다.
 * 5) 마지막 답은 D 배열 중에 가장 큰 Max값을 찾아서 출력하면 된다.
 */

public class P11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int[] num = new int[size+1];
		int[] d = new int[size+1];
		
		for(int i = 1;i<=size;i++){
			num[i] = sc.nextInt();
		}
		
		//백준이 깔끔하게 푼거
		for(int i = 1;i<=size;i++){
			d[i] = 1;
			for(int j = 1;j<i;j++){
				if(num[i]>num[j] && d[i]<d[j]+1){
					d[i] = d[j]+1;
				}
			}
			
		/*내가 했던건데 백준이 한거랑 알고리즘은 같지만 너무 조건을 늘여놓고, d[i] 값을 주는게 복잡함
		 * for(int i = 2; i<=size;i++){
			int index = 0;
			int max = 0;
			for(int j = 1;j<i;j++){
				if(d[j] > d[index] && num[j] < num[i]){
					index = j;
				}
			}
			if(index == 0){
				d[i] = 1;
			}
			else if(index != i){
				d[i] = d[index]+1;
			}
			else if(num[index] == num[i]){
				d[i] = d[index];
			}*/
			
		}
		Arrays.sort(d);
		System.out.println(d[size]);
		
	}
}

/*
 * 20
 * 2 54 77 21 14 32 68 47 22 10 6 85 77 85 111 140 25 43 31 11
 * 출력 : 8
 * 
 * 6
 * 10 20 10 30 20 50
 * 출력 : 4
 */