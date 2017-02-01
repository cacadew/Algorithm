package DynamicProgramming1;

import java.util.Scanner;

/* 포도주 시식 - 2차원 배열 사용해서 풀기
 * 
 * 일렬로 놓아진 n개의 포도주 잔에 포도주의 양을 숫자로 적어놨다.
 *  1. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
 *  2. 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 * 예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때,
 * 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.
 * 
 * 접근방법
 * 
 * D[i][j] : i번째 마시는 포도잔이 연속 j번째 마시는 잔이다.
 * D[i][0] : i번째 포도주를 마시지 않는다. D[i] = Math.max(D[i-1][0], D[i-1][1], D[i-1][2]);
 * D[i][1] : i번째 마시는 포도주가 첫번째 마시는 잔이다. 대신 첫번째로 마시는 잔! 따라서 D[i-1]번째에는 마시지 않았어야 한다.
 * 			따라서, D[i][1] = D[i-1][0] + A[i];
 * D[i][2] : i번째 마시는 포도주가 두번째 마시는 잔이다. 때문에 바로 앞 i-1번째에서는 첫번째로 마시는 잔이 있어야한다.
 * 			따라서, D[i][2] = D[i-1][1] + A[i];
 * 구하려고 하는 n번째 행에서 최대값이 최대로 얻을 수 있는 포도주의 양이다.
 */
public class P2156_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int[] wine = new int[num+1];
		int[][] d = new int[num+1][3]; // d[i][j] == i번째에 마시는 포도주가 j번째 마시는 잔
		
		for(int i = 1;i<num+1;i++){
			wine[i] = sc.nextInt();
		}
		
		d[1][1] = wine[1]; //첫번째 와인을 마시는경우!
		
		for(int i = 2;i<num+1;i++){
			d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
			d[i][1] = d[i-1][0] + wine[i];
			d[i][2] = d[i-1][1] + wine[i];
		}
		
		int ans = Math.max(d[num][0], Math.max(d[num][1], d[num][2])); //d[num][]중에서 최댓값이 정답
		System.out.println(ans);
	}
}
