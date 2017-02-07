package Math;

import java.util.Scanner;
/* 2진수 8진수
 * 2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) 2진수를 3자리씩 묶어버리면, 한 묶음이 8진수의 숫자 1개가 된다.
 * 2) 3자리씩 묶었을 때 남는 자릿 수를 따로 처리해주면 된다.
 * 
 */
public class P1373 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int size = line.length();

		if(size %3 == 1) //3자리씩 묶고 1개가 남을 때, 가장 첫째수이므로 먼저 계산하여 출력한다.
			System.out.print(line.charAt(0)-48);
		else if(size %3 == 2)// 3자리씩 묶고 2개가 남았을 때, 먼저 계산하여 출력
			System.out.print((line.charAt(0)-48)*2 + (line.charAt(1)-48));
		
		for(int i = size%3;i<size;i+=3){// 3자리씩 묶고 남은 수들을 미리 다 출력했으므로 i = size%3부터 시작!! 3자리씩 처리하니까 i는 3씩 증가
			System.out.print((line.charAt(i)-'0')*4 + (line.charAt(i+1)-'0')*2 + (line.charAt(i+2)-'0'));
			
		}
		
		
	}
}
