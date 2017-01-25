package DataStructure1;

import java.util.Scanner;
import java.util.Stack;

//레이저로 쇠막대기 쪼개는 문제

/*
 * 접근 방식
 * 1) 열린괄호와 닫힌괄호가 연이어서 들어올 때 레이저인 것을 알 수 있다.
 * 2) 괄호의 순서를 활용하기 위해서 for문에서 선언된 i 변수를 이용한다.
 * 3) '('일때 스택에 i를 push, 닫힌괄호가 연이어 들어오는 것은 i값과 스택의 top의 값이 1 차이 나는지 확인해서 알수 있다. 
 * 4) 만약 닫힌괄호가 연이어서 들어오면 , 레이저로 쇠막대기가 절단된 것이므로 쇠막대기 갯수를 구하는 변수 result+=남은 스택의 사이즈 를 해준다.
 * 5) 닫힌괄호가 연이어서 들어오지 않은 경우는 막대기의 길이가 끝난 것이다. 따라서 result++ 을 해준다. 2등분하면 막대기 3개 나오니까!
 *  
 */
public class P10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		
		for(int i = 0;i<line.length();i++){
			if(line.charAt(i)=='('){
				stack.push(i);
			}
			else{//닫힌 괄호가 들어왔을 때!
				if(i-stack.peek() == 1){//연이어서 들어왔을 경우
					stack.pop();
					result+=stack.size();
				}
				else{//띄엄띄엄 들어왔을 경우
					stack.pop();
					result++;
				}
			}
		}//for-end
		System.out.println(result);
	}
}
