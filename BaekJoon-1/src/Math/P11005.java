package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 진법변환2
 * 
 * 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 * A: 10, B: 11, ..., F: 16, ..., Y: 34, Z: 35
 * 
 * 접근방법
 * 1) a를 b로 나누면서 나머지를 배열에 저장한 후 역으로 출력하면 된다. 이때 나머지가 10 이상일 경우 알파벳으로 변환이 필요하다.
 * 2) while문의 나머지연산을 할 때 주의할 점은, 제일 마지막 연산에서 몫이 0이 아닐때, 몫을 배열에 넣어줘야 한다는 것이다.
 * 3) 아래 소스에서는 나머지 숫자를 int형 arryList에 저장을 했지만, char형 arrayList를 사용해서 10 이상일 때 바로 알파벳으로 바꿔 저장하는게 더 좋다.
 * 4) 아래 소스에서는 출력할 때 사용한 for문에서 i = m.size()-1 부터 0까지 범위를 주었고, if문으로 m.get(i)가 10 이상일때 처리할 조건문을 넣었지만
 * 5) 3)과 같이 할 경우 if문이 필요없고, for문 전에 Collections.reverse(m)을 해서 m을 뒤집어줘서 바로 출력해도 된다.
 */
public class P11005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
				
		ArrayList<Integer> m = new ArrayList<Integer>(); //int형말고 char형으로 하면 출력 형태 구할 때 더 nice함
		
		long temp = a;
		
		while(temp/b >= b){
			m.add((int) (temp%b));
			temp = temp/b;
		}
		m.add((int)(temp%b));
		if(temp/b != 0)
			m.add((int)(temp/b));
		
		//Collections.reverse(m); 어레이리스트 순서 바꾸기
		
		for(int i = m.size()-1;i>=0;i--){
			if(m.get(i) > 9){
				char c = (char) ('A' + m.get(i) - 10);
				System.out.print(c);
			}
			else
				System.out.print(m.get(i));
		}
	}
}
