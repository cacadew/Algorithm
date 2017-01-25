package InputOutput;

import java.util.Scanner;

public class P10992 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numOfLine = sc.nextInt();
		
		for(int i = 1; i<=numOfLine;i++){
			if(i== numOfLine){
				for(int j = 1; j<numOfLine*2;j++){
					System.out.print("*");
				}
			}
			else{
				for(int j = 0; j<numOfLine-i;j++){
					System.out.print(" ");
				}
				System.out.print("*");
				
				for(int j = 0; j<(i-1)*2-1;j++){
					System.out.print(" ");
				}
				if(i!=1)
					System.out.println("*");
				else
					System.out.println();
			}
			
		}
	}
}

/*
 * 출력형태 : 
 4
   *
  * *
 *   *
*******

 * */
