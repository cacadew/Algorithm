package InputOutput;

import java.util.Scanner;

//문제번호 : 10952
public class SumAB_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			String str = sc.nextLine();
			int a = str.charAt(0)-48;
			int b = str.charAt(2)-48;
			
			if(a==0 && b==0)
				break;
			System.out.println(a+b);
		}
	}
}
