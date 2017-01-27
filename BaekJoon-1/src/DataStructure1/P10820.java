package DataStructure1;

import java.util.Scanner;

/*
 * 문자열 N개가 주어진다. 이 때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
 * 각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.
 * 
 * 엽력형태
 * 
This is String
SPACE    1    SPACE
 S a M p L e I n P u T     
0L1A2S3T4L5I6N7E8
 *
 * 출력형태
 * 
10 2 0 2 소문자, 대문자, 숫자, 공백
0 10 1 8
5 6 0 16
0 8 9 0
 * 접근방법
 * 1)
 * 2)
 * 
 */
public class P10820 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			String line = sc.nextLine();
			int[] cnt = new int[4];
			for(int i =0;i<cnt.length;i++){
				cnt[i] = 0;
			}
			for(int i =0;i<line.length();i++){
				char c = line.charAt(i);
				
				if(c<='z' && c>='a')
					cnt[0]++;
				else if(c<='Z' && c>='A')
					cnt[1]++;
				else if(c<='9' && c>='0')
					cnt[2]++;
				else
					cnt[3]++;
			}
			
			for(int i =0;i<cnt.length;i++){
				System.out.print(cnt[i]+" ");
			}
			System.out.println();
		}
	}
}
