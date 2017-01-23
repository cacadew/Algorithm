package InputOutput;

import java.util.Scanner;


//문제번호 : 10953
public class SumAB_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		sc.nextLine();
		/*nextInt() 다음에 nextLine() 쓰려면 '\n'으로 구분이 필요하다.
		nextInt()는 숫자만 읽고 '\n'은 사용하지 않음.
		따라서 그 다음 nextLine()을 사용할 때 앞에 int값을 인풋으로 받지 않고 제대로 사용하려면
		sc.nextLine()을 사용해서 '\n'으로 구분을 지어줘야함
		*/
		while(testcase-- >0){
			String str = sc.nextLine();
			int a = str.charAt(0)-48;
			int b = str.charAt(2)-48;
			
			System.out.println(a+b);
		}
		
	}
}
