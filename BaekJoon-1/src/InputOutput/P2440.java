package InputOutput;

import java.util.Scanner;

public class P2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numOfLine = sc.nextInt();
		
		for(int i = 0 ; i<numOfLine;i++){
			for(int j=i;j<numOfLine;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
/*
 * 
 출력형태

5

*****
****
***
**
*


 */