package InputOutput;

import java.util.Scanner;

public class P2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numOfLine = sc.nextInt();
		
		for(int i = 0; i<numOfLine; i++){
			for(int j =0;j<i;j++){
				System.out.print(" ");
			}
			for(int j = i;j<numOfLine;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

/*
 * 
 === 출력 형태 ===
5
*****
 ****
  ***
   **
    *
 */