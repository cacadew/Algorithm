package March5;

import java.util.Scanner;
/* 저작권 문제 - 알고리즘 분류 : 수학
 * 저작권이 있는 멜로디의 평균값 = 앨범에 수록된 곡에 포함되어 있는 저작권이 있는 멜로디 개수 / 앨범에 수록된 곡의 개수
 * 
 * 접근방법
 * 1)평균값은 항상 소수점 올림을 하여 정수로 만들어지기 때문에 실제 평균은 avg-1보다 크기만 하면 된다.
 * 2)따라서 전체 앨범 수록곡 * (avg(올림된 평균값이자 입력값)-1) +1을 해주면 적어도 몇 곡이 저작권이 있는 멜로디인지 알 수 있다. 
 * 
 */
public class P2914 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int songNum = Integer.parseInt(sc.next());//앨범에 수록된 곡의 개수
		int avg = Integer.parseInt(sc.next());//올림된 평균값
		
		//ans는 저작권이 있는 멜로디 개수
		int ans = songNum*(avg-1)+1;//
		System.out.println(ans);
	}
}
