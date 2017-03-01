package Greedy;

import java.util.Arrays;
import java.util.Scanner;
/* 30
 * 입력받은 어떤 수를 조합하여 30으로 나누어 떨어지는 최대의 수를 만들어라! 30으로 나누어 떨어지지 않을 경우 -1 출력
 * 예) 201 -> 210, 2931 -> -1
 * 입력받는 수의 길이는 최대 10^5 이다.
 * 
 * 접근방법
 * 1) 입력받는 수의 길이가 int랑 long으로 표현하기가 어렵기 때문에 문자열로 입력받고 char형 배열로 쪼개어 저장한다.
 * 2) 숫자들 중에 0이 없으면 30으로 나누어 떨어지지가 않다는 점과, 각 자리수의 합이 3으로 나누어 떨어지면 3의 배수인 것을 이용한다.
 * 2-1) boolean 타입의 변수를 만들어 char 배열을 돌면서 0이 나오면 true로 변한다.
 * 2-2) char배열의 숫자를 sum이라는 변수에 합한다 ->3의 배수가 되는지 확인하려고!
 * 3) if문을 수행. 0이 없거나 혹은 각 자리 수의 합계(sum)가 3으로 나누어 떨어지지 않으면, 30으로 안나눠지는 수임으로 -1출력후 종료
 * 4) char배열을 정렬한 후 뒤에서부터 출력한다! 가장 큰 수여야 하므로 
 * 
 */
public class P10610 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] ch = sc.next().toCharArray();
		boolean zero = false;
		
		long sum = 0;
		for(int i = 0; i<ch.length;i++){
			int n = ch[i]-48;
			if(n == 0){
				zero = true;
			}
			sum+=n;
		}
		if(zero == false || sum%3 != 0){
			System.out.println(-1);
			return;
		}
		Arrays.sort(ch);
		for(int i = ch.length-1;i>=0; i--){
			System.out.print(ch[i]);
		}
	}
}
