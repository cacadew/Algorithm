package InputOutput;

import java.util.Scanner;

public class P10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();

		int min = 0;
		int max = 0;
		
		for(int i = 0;i<num;i++){
			if(i==0){
				min = sc.nextInt();
				max = sc.nextInt();
				
				i++;
				continue;
			}
			int a = sc.nextInt();
			
			if(a > max)
				max = a;
			if(a < min)
				min = a;
		}
		
		System.out.println(min +" "+max);
	}
}
