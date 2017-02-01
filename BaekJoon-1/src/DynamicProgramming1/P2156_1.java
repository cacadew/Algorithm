package DynamicProgramming1;

import java.util.Scanner;

/*
 * 포도주 시식 - 1차원 배열 사용해서 풀기
 * 
 * 일렬로 놓아진 n개의 포도주 잔에 포도주의 양을 숫자로 적어놨다.
 *  1. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
 *  2. 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 * 예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때,
 * 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.
 * 
 * 접근방법
 * 
 * D[i] = A[1]~A[i] 번째 까지 포도주를 마셨을 때, 마실 수 있는 포도주의 최대 양이다.
 * i번째 포도주를 마시지 않을경우 : D[i] = D[i-1];
 * i번째 포도주를 첫번째 마시는 경우 : D[n-2]+ A[i]; n번째가 첫번째이면 n-1번째는 무조건 마시면 안되니까 D[n-2]에 A[i]를 더해주는것
 * i번째 포도주를 두번째 마시는 경우 : D[n-3]+ A[i-1]+ A[i]; n번째가 두번째일 경우, n-1번째도 마셔야하고, n-2번째는 안마셔야한다. 따라서 D[n-3]에  A[i-1]과 A[i]을 더해줌
 * 
 * 주의 : n-3까지 점화식에 포함되어 있기 때문에 인덱스 예외처리가 복잡하다. 이럴때는 D[1],D[2]까지는 입력을 하고 시작하는게 편하다!
 * n의 범위가 1 이상이다. 따라서, n이 1일때 배열에 d[2]는 없기때문에 런타임에러가 발생한다. 예외처리 필요!
 */
public class P2156_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] wine = new int[num+1];
		int[] d = new int[num+1];
		
		for(int i = 1; i<=num;i++){
			wine[i] = sc.nextInt();
		}
		
		d[1] = wine[1];
		
		if(num > 1){// num의 크기가 1일 때, 런타임에러나서 예외처리함
			
			d[2] = d[1]+wine[2];
			
			for(int i = 3;i<=num;i++){
				d[i] = d[i-1];//d[i]가 0번째 마시는 포도주일 경우
				
				if(d[i] < d[i-2]+wine[i]){//d[i]가 1번째 마시는 포도주일 경우
					d[i] = d[i-2]+wine[i];
				}
				if(d[i] < d[i-3]+wine[i-1]+wine[i]){//d[i]가 2번째 마시는 포도주일 경우
					d[i] = d[i-3]+wine[i-1]+wine[i];
				}
			}
		}
		
		System.out.println(d[num]);
		
	}
}
