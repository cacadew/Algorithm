package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/* -2진수
 * -2진법은 부호 없는 2진수로 표현이 된다. 2진법에서는 20, 21, 22, 23이 표현 되지만 -2진법에서는 (-2)0 = 1, (-2)1 = -2, (-2)2 = 4, (-2)3 = -8을 표현한다.
 * 10진수로 1부터 표현하자면 1, 110, 111, 100, 101, 11010, 11011, 11000, 11001 등이다.
 * 10진법의 수를 입력 받아서 -2진수를 출력하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) -2진수는 음수를 -2로 나누면 양수가 되고, 양수를 -2로 나누면 음수가 되기 때문에 부호가 계속 바뀐다.
 * 2) -2진수에서 음수의 나눗셈에서 -7/2 = -3이 아니고 -4가 되어야한다. 왜냐하면 나머지가 음수가 나오면 안되기 때문에!!!!!
 * 3) ex) -7%-2는 1이고, -7/-2 = 4 이다. ex) -3/-2 = 2
 */
public class P2089 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		if(n==0){
			System.out.println(0);
			return;
		}
		while(n != 1){
			if(n > 0){//양수이면 일반 2진수 계산처럼 mod2를 넣어주고 n에는 -를 붙인다.
				ans.add((int)(n%2));
				n = -(n/2);
			}
			else{
				if(n%2==0){
					ans.add(0);
					n = -(n/2);
				}
				else{
					ans.add(1);
					n = -(n-1)/2; //-2진수 계산에서 나머지가 음수가 나오면 안되기 때문에 홀수 음수의 경우 -1을 더 해주고나서 2로 나눈다. 접근방법 2,3참고
				}
			}
		}
		System.out.print(1);//while문에서 가장 마지막 몫 1이 출력되지 않기 때문에 arraylist 출력전 먼저 print
		Collections.reverse(ans);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i));
		}
	}
}
