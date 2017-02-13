package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/* 수 정렬하기3
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) 입력되는 숫자를 배열의 인덱스로 한다. 2가 들어왔다면 num[2]++
 * 2) 출력할 때 num[2]값이 3이라면 3번 반복해서 2를 출력한다.
 * 3) 문제는 시간초과가 난다는 것인데, 입출력을 모두 Buffer를 사용해야 한다!!!
 * 
 */
public class P10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		int[] num = new int[10001];//미리 배열을 만들어놓는다. 숫자가 몇까지 들어올지 모르니 범위만큼 만들기
		
		while(tc-->0){
			int temp = Integer.parseInt(br.readLine());
			num[temp]++;//입력받은 값을 인덱스로 해서 해당 배열의 값을 1씩 증가해줌

		}
		StringBuffer buffer = new StringBuffer();
		for(int i = 1; i<=10000;i++){
			int iter = num[i];//배열의 값을 iter에 저장하고, iter만큼 반복해서 i를 출력
			if(iter != 0){
				for(int j = 0; j<iter;j++){
					buffer.append(i+"\n");//StringBuffer에 저장
				}
			}
		}
		System.out.println(buffer.toString());//StringBuffer로 출력!
	}
}
