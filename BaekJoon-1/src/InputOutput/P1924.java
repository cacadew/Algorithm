package InputOutput;

import java.util.Scanner;

public class P1924 {
	public static void main(String[] args) {
		
		/*final int SUN = 0;
		final int MON = 1;
		final int TUE = 2;*/
		
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int d = sc.nextInt();
		
		int[] month = new int[13];
		month[0] = 0;
		month[1] = month[3] = month[5] = month[7] = month[8] = month[10] = month[12] = 31;
		month[4] = month[6] = month[9] = month[11] = 30;
		month[2] = 28;
		
		String[] day = new String[7];
		day[0] = "SUN";
		day[1] = "MON";
		day[2] = "TUE";
		day[3] = "WED";
		day[4] = "THU";
		day[5] = "FRI";
		day[6] = "SAT";
		
		int dTemp=0;
		for(int i = 0; i<m;i++){
			dTemp += month[i];
		}
		dTemp += d;
		
		String result = day[dTemp%7];
		System.out.println(result);
	}
}
