package InputOutput;

import java.util.Scanner;

public class P2444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numOfLine = sc.nextInt();
		
		for(int i = 1; i<numOfLine*2;i++){
			if(i<=numOfLine){
				for(int j = 0; j<numOfLine-i;j++){
					System.out.print(" ");
				}
				for(int j = 0; j<i;j++){
					System.out.print("*");
				}
				for(int j = 0; j<i-1;j++){
					System.out.print("*");
				}
				System.out.println();
			}
			else{
				for(int j = 0;j<i-numOfLine;j++){
					System.out.print(" ");
				}
				for(int j = 0;j<numOfLine*2-i;j++){
					System.out.print("*");
				}
				for(int j = 1;j<numOfLine*2-i;j++){
					System.out.print("*");
				}
				System.out.println();
			}
			
		}
	}
}
/*
 * 출력형태
 5
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
  
 * */
