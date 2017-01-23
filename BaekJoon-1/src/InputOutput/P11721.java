package InputOutput;

import java.util.Scanner;

public class P11721 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		if(str.length() <10)
			System.out.println(str);
		else{
			int n = 10;
			
			System.out.println(str.substring(0, n));
					
			while(str.length()-n != str.length()%10){
				System.out.println(str.substring(n, n+10));
				n+=10;
			}
			
			System.out.println(str.substring(n));
		}
		
		
		
	}
}
