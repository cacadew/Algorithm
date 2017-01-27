package DataStructure1;

import java.util.Arrays;
import java.util.Scanner;

/* 접미사 배열
 * 접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.
 * baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
 * 문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) 문자열을 입력받은 후 문자열 길이만큼의 String 배열을 생성한다.
 * 2) subString 메소드를 사용해서 for문의 i 인덱스를 begin 파라미터로 사용해서 배열에 하나씩 값을 넣어준다.
 * 3) Arrays.sort()를 사용해 정렬 후 출력!
 */
public class P11656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		
		String[] str = new String[line.length()];
		
		for(int i = 0; i<str.length;i++){
			str[i] = line.substring(i);
		}
		
		Arrays.sort(str);
		
		for(int i = 0;i<str.length;i++){
			System.out.println(str[i]);
		}
	}
}
