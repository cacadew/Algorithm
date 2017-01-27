package DataStructure1;

import java.util.Scanner;

/*
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다. 이 때, 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) 알파벳 갯수 26 크기의 배열을 만들어 0으로 초기화 한 후, 입력되는 문자열의 각 알파벳이 나오면 해당 배열값을 +1 한다.
 * 2) 'a'의 아스키 코드 값이 97 이다. 따라서  a-97 == 0, b-97 == 1 이렇게 값이 나오는걸 알파벳 배열의 인덱스로 사용한다.
 */
public class P10808 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();//문자열 입력받음
		
		int[] alp = new int[26];//알파벳 크기의 배열 생성
		
		for(int i = 0;i<alp.length;i++){//alp 배열 0으로 초기화
			alp[i] = 0;
		}
		
		for(int i = 0; i<str.length();i++){//각 글자의 아스키코드값에서 97을 빼준 후 알파벳 배열의 인덱스로 사용하여 ++을 해준다. 
			alp[str.charAt(i)-97]++;	//alp[str.charAt(i)-'a']++; 이렇게 해도 됨!!!
		}
		
		/*char ch = 'b';
		System.out.println((int)ch - 97);//1출력
		 */
		
		for(int i = 0; i<alp.length;i++){
			System.out.print(alp[i]+" ");
		}
	}
}
