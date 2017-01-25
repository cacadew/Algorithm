package InputOutput;

import java.util.Scanner;

public class P10991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numOfLine = sc.nextInt();
		
		for(int i = 1; i<=numOfLine;i++){
			for(int j = 0; j<numOfLine-i;j++){
				System.out.print(" ");
			}
			for(int j = 0;j<i;j++){
				System.out.print("* ");
			}
			System.out.println();
			
		}
	}
}

/*
 * 출력형태 : 
3
  * 
 * * 
* * * 


 */
