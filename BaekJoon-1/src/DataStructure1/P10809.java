package DataStructure1;

import java.util.Scanner;

/*
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
 * 각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
 * 만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
 * 
 * 입력 예시 : baekjoon
 * 출력 예시 : 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 * 
 * 접근방법
 * 1) 알파벳 갯수 26 크기의 배열을 모두 -1로 초기화
 * 2) 입력된 문자열의 각 문자의 아스키 코드 값에 'a' 크기만큼 빼서 배열의 해당 인덱스값으로 사용함.
 * 3) for문으로 입력된 문자열을 반복하면서 배열에 -1값일 경우 for문에서 선언한 i 인자 값을 배열의 값으로 넣어줌
 */
public class P10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int[] alp = new int[26];//카운트를 저장할 알파벳 배열
		
		for(int i = 0;i<alp.length;i++){//-1로 초기화. 
			alp[i] = -1;
		}
		
		for(int i = 0;i<str.length();i++){
			if(alp[str.charAt(i)-'a'] == -1)//해당하는 알파벳의 배열 값이 -1인지 확인. -1이 아닐경우 처음등장이 아니니까 넘어간다.
				alp[str.charAt(i)-'a'] = i;//for문의 i가 현재 문자열에서의 위치를 나타내므로 배열에 i값을 넣어준다.
		}
		
		for(int i = 0; i<alp.length;i++){
			System.out.print(alp[i]+" ");
		}
	}
}
