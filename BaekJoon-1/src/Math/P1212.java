package Math;

import java.util.ArrayList;
import java.util.Scanner;

/* 8진수 2진수
 * 8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) 8진수의 숫자 하나를 2진수로 3자리씩 변환하여 출력하면 된다.
 * 2) 주의해야할 점은 가장 처음 0이 출력되지 않고, 1로 시작하는 것이다.
 * 3) 2진수로 나타낼 수 있는 0~ 7까지 수를 배열에 저장하여 가장 처음 start일때는 0을 제외하고 출력될 수 있도록 한다.
 */
public class P1212 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String[] eight = {"000","001","010","011","100","101","110","111"};
		
		if(s.equals("0")){
			System.out.println(0);
			return;
		}
		
		boolean start = true;
		
		for(int i = 0; i<s.length();i++){
			int n = s.charAt(i)- 48;
			if(start && n <4){
				if(n == 0)continue;
				else if(n == 1)System.out.print("1");
				else if(n == 2)System.out.print("10");
				else if(n == 3)System.out.print("11");
				start = false;
				
			}
			else{
				System.out.print(eight[n]);
				start = false;
			}
		}
		
		
	}
}
