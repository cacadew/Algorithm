package DataStructure1;

import java.util.Scanner;
import java.util.Stack;

/* 괄호 짝 맞추는 문제 - 올바르게 구성되었는지! 스택사용
 * 스택 사용하지 않고 열린괄호'(' 일때 cnt++, 닫힌 괄호')'일때는 cnt-- 해서 계산해도 됨.
 * but, 괄호 종류가 2가지 이상일 경우 스택 사용해서 비교하는 과정 필요함
*/
public class P9012 {
	
	static String inValid(String line){
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i<line.length();i++){
			if(line.charAt(i)=='('){
				stack.push(line.charAt(i));
			}
			else{//닫힌 괄호일 때
				if(stack.isEmpty())
					return "NO";
				else
					stack.pop();
			}
		}
		if(!stack.isEmpty())
			return "NO";
		else
			return "YES";
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		sc.nextLine();
		
		while(tc-->0){
			String line = sc.nextLine();
			System.out.println(inValid(line));
		}
		
	}
}
