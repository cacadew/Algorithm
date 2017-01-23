package InputOutput;

import java.util.Scanner;

//문제번호 : 10950
public class SumAB_2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int i = 0; i<testcase ;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println(a+b);
		}
	}
}
