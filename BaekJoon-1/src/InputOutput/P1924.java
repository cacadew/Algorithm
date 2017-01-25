package InputOutput;

import java.util.Scanner;
/*
 * 오늘은 2007년 1월 1일 월요일이다.
 * 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.
 * 첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.
 * */
public class P1924 {
	public static void main(String[] args) {
		
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
