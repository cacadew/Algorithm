package DataStructure1;

import java.math.BigInteger;
import java.util.Scanner;

/*네 수
 * 
 * 네 자연수 A, B, C, D가 주어진다. 이 때, A와 B를 붙인 수와 C와 D를 붙인 수의 합을 구하는 프로그램을 작성하시오.
 * 두 수를 A와 B를 합치는 것은 A의 뒤에 B를 붙이는 것을 의미한다. 즉, 20과 30을 붙이면 2030이 된다. (1 ≤ A, B, C, D ≤ 1,000,000)
 * 
 * 접근방법
 * 1) 입력되는 수를 배열에 저장한 후, 숫자 2개씩 String으로 concat한다.[숫자 뒤에 +""를 해주던가, Integer.toString()을 하면 String으로 바뀜
 * 2) 다시 integer로 형변환을 하여 두 수를 더한 후 출력!
 * 3) 주의★★ 숫자가 1000000 일때, Int의 범위가 넘어가기 때문에 BigInteger를 사용해야 한다.
 * 		또는, Long.valueOf()를 사용해서 int가 아닌 long으로 변환하면 된다.
 */
public class P10824 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[4];
		
		for(int i =0;i<num.length;i++){
			num[i] = sc.nextInt();
		}
		
		//String strNum1 = num[0]+""+num[1];
		//String strNum2 = num[2]+""+num[3];
		
		String strNum1 = Integer.toString(num[0])+Integer.toString(num[1]);
		String strNum2 = Integer.toString(num[2])+Integer.toString(num[3]);
		
		BigInteger bigInt1 = new BigInteger(strNum1);
		BigInteger bigInt2 = new BigInteger(strNum2);
		
		System.out.println(bigInt1.add(bigInt2));
	}
}
