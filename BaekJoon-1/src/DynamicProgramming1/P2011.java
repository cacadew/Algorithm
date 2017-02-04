package DynamicProgramming1;

import java.util.Scanner;
/* 암호코드
 * A를 1이라 하고, B는 2, Z는 26이라고 암호화한다.
 * "BEAN"을 암호화하면 25114가 나오는데 이걸 다시 글자로 바꾸는 방법이 여러가지가 있다.
 * "BEAAD", "YAAD", "YAN", "YKD", "BEKD", "BEAN" 총 6가지가 나온다.
 * 어떤 암호가 주어졌을 때, 그 암호의 해석이 몇 가지가 나올 수 있는지 구하는 프로그램을 작성하시오.
 * 나올 수 있는 해석의 가짓수를 구하시오. 정답이 매우 클 수 있으므로, 1000000으로 나눈 나머지를 출력한다.
 * 
 * 접근방법
 * 1) 암호를 입력받아 int형 배열에 split해서 저장한다.
 * 2) D[n]은 n번째까지 해석했을 때 나오는 해석의 가짓수 이다.
 * 3) arr[i] >0 이면 A~J까지 중에 가능하므로 D[i] +=D[i-1];
 * 4) arr[i-1]*10 + arr[i] 가 10이상 26이하일때 K~Z가 가능하므로, d[i] += d[i-2];
 * 
 */
public class P2011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String crypt = sc.nextLine();
		if(crypt.equals("0")){
			System.out.println(0);
			return;
		}
		else if(crypt.length() == 1){
			System.out.println(1);
			return;
		}
		
		
		int[] arr = new int[crypt.length()+1];
		int[] d = new int[crypt.length()+1];
		
		for(int i = 1;i<arr.length;i++){
			arr[i] = crypt.charAt(i-1) - 48;
		}
		d[0] = 1;
		d[1] = 1;
		
		for(int i = 2;i<d.length;i++){
			if(arr[i] > 0)
				d[i] += d[i-1];
			
			int temp = arr[i-1]*10 + arr[i];
			if(temp >9 && temp<27)
				d[i] += d[i-2];
		}
		System.out.println(d[crypt.length()]);
	}
}
