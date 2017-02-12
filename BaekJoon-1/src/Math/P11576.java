package Math;

import java.util.ArrayList;
import java.util.Scanner;
/* Base Conversion -A진법을 B진법으로 변환
 * 입력의 첫 줄에는 미래세계에서 사용하는 진법 A와 정이가 사용하는 진법 B가 공백을 구분으로 주어진다. A와 B는 모두 2이상 30이하의 자연수다.
 * 입력의 두 번째 줄에는 A진법으로 나타낸 숫자의 자리수의 개수 m(1 ≤ m ≤ 25)이 주어진다. 세 번째 줄에는 A진법을 이루고 있는 숫자 m개가 공백을 구분으로 높은 자릿수부터 차례대로 주어진다.
 * 각 숫자는 0이상 A미만임이 보장된다. 또한 수가 0으로 시작하는 경우는 존재하지 않는다. A진법으로 나타낸 수를 10진법으로 변환하였을 때의 값은 양의 정수이며 220보다 작다.
 * 입력으로 주어진 A진법으로 나타낸 수를 B진법으로 변환하여 출력한다.
 * 
 * 접근방법
 * 1) A진법을 10진법으로 바꾼 후, 10진법 수를 B진법으로 변환하면 된다.
 */
public class P11576 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(); // A행성 진법
		int b = sc.nextInt(); // B행성 진법
		
		int m = sc.nextInt(); //a진법의 숫자 자릿수의 개수 m
		int[] num = new int[m];
		
		for(int i = 0; i<m;i++){
			num[i] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i = 0; i<m;i++){//a진법을 10진법으로 변환
			ans = ans*a + num[i];
		}
		
		int temp = ans;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(temp/b >=b){ // 몫이 b보다 작아질때까지 계속 b로 나눔
			arr.add(temp%b);
			temp = temp/b;
		}
		arr.add(temp%b); //마지막 나머지 더하기
		if(temp/b >0)	//마지막 몫이 0이면 출력하지 말아야 하므로, temp/b >0일때 arraylist에 몫을 추가한다.
			arr.add(temp/b);
		
		for(int i = arr.size()-1;i>=0;i--){
			System.out.print(arr.get(i)+" ");
		}
		
	}
}
