package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/* 수 묶기
 * 길이가 N인 수열이 주어졌을 때, 그 수열의 숫자 2개씩 묶을 수 있다. 묶은 수를 서로 곱한 후에 더했을 때 그 합이 최대가 되는 값을 구해라!
 * 예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다.
 * 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.
 * 
 * 접근방법
 * 1) 양수는 큰 수끼리 묶어 곱하여 주고, 음수는 작은 수끼리 묶어 곱하여 준다.
 * 1-1) 양수는 곱해서도 양수니까 큰 수끼리, 음수는 곱했을 때 양수가 되니까 절대값이 큰 수끼리 곱하는 것!
 * 2) 양수를 저장할 배열과 음수를 저장할 배열을 나누어 입력받은 후 정렬한다.
 * 3) 각 배열을 for문으로 순회하면서 ans변수에 값을 누적한다.
 * 4) 주의해야할 점은, 양수를 계산할 때 곱셈보다 덧셈일때 큰 값들이 있다. 예를들어 1,2가 있다. 1+2>2*2 예외처리가 필요
 * 
 */
public class P1744 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		ArrayList<Integer> pl = new ArrayList<Integer>(); // 양수 저장
		ArrayList<Integer> mi = new ArrayList<Integer>(); //음수 저장
		int ans = 0;
		
		for(int i = 0; i<size;i++){//입력받은 값이 0보다 큰지 작은지를 비교하여 각 배열에 저장
			int temp = sc.nextInt();
			if(temp > 0)
				pl.add(temp);
			else
				mi.add(temp);
		}
		
		Collections.sort(pl);//오름차순 정렬
		Collections.reverse(pl);// 양수는 내림차순 정렬이 되어야 하므로, 오름차순으로 정렬된 배열을 뒤집는다.
		
		Collections.sort(mi);//오름차순 정렬 ex)-5,-4,-2,-1
		
		//양수 계산
		for(int i = 0; i<pl.size();i+=2){//숫자를 2개씩 묶으니까 한번 for문을 돌 때, 2개의 수를 사용하니까 2씩증가시킨다.
			int x = pl.get(i);
			if(pl.size()> i+1){//배열의 길이가 홀수일때 예외처리
				int y = pl.get(i+1);
				
				if(x*y < x+y)
					ans += x+y;
				else
					ans +=x*y;
			}
			else//마지막 수 하나가 남을때는 그냥 더해준다.
				ans +=x;
			
		}
		
		//음수 계산
		for(int i = 0; i<mi.size();i+=2){
			int x = mi.get(i);
			if(mi.size()>i+1){
				int y = mi.get(i+1);
				
				ans += x*y;
			}
			else
				ans+=x;
		}
		
		System.out.println(ans);
		
	}
}
