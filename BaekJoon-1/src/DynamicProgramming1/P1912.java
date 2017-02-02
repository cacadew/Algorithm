package DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

/* 연속합
 * n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 숫자를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 숫자는 한 개 이상 선택해야 한다.
 * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
 * 
 * 접근방법
 * 1) 음수도 선택을 해야지 최대값을 구할 수 있다. ex) 5, -1, 5
 * 2) D[i] = A[i]로 끝나는 최대 연속 합
 * 3) 2가지 케이스가 있다. 하나는 A[i-1]로 끝나는 연속합에 포함 =>D[i-1]+A[i]
 * 4) 또 하나는 A[i]를 연속합의 시작으로 하는 것이다. => D[i] = A[i]
 * 5) 따라서 D[i-1]+A[i] 와 A[i]를 비교하여 D[i-1]+A[i]가 크면 D[i] = D[i-1]+A[i], A[i]가 크면 D[i] = A[i] 해주면 된다.
 */
public class P1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] num = new int[n];
		int[] d = new int[n];
		
		for(int i = 0; i<n;i++){
			num[i] = sc.nextInt();
			d[i] = num[i];
		}
		
		for(int i = 1;i<n;i++){
			d[i] = num[i];
			if(d[i] < d[i-1]+num[i]){
				d[i] = d[i-1]+num[i];
			}
		}
		//처음에 풀었던 방식인데 범위가 복잡하고 시간복잡도 높음. 1개 연속일때, 2개연속일때, 3개연속일때, ~ n개가 연속할때까지의 합계를 모두 구함 ㅜㅠ;;
		/*for(int i = 1;i<n;i++){
			for(int j = i;j<n;j++){
				if(j-i >=0){
					d[j] = d[j] + num[j-i];
					if(max < d[j])
						max = d[j];
				}
			}
		}*/
		Arrays.sort(d);
		System.out.println(d[n-1]);
		
	}
}
/*
10
10 -4 3 1 5 6 -35 12 21 -1
출력 : 33

2
-1 -2
출력 : -1

3
5 -100000 1000001
출력 : 1000001
*/