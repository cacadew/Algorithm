package DataStructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/*
 * 에디터 문제 - 커서의 위치에 따라 텍스트 편집하기
 * 
 * 접근방식
 * 1) 커서를 기준으로 왼쪽에 위치한 문자열을 저장할 left 스택, 오른쪽에 위치한 문자열을 저장할 right 스택을 만든다.
 * 2) 커서가 왼쪽으로 한칸 이동(L) 일 경우, left 스택의 인자를 pop하고 right 스택에 push 한다.
 * 3) 커서을 오른쪽으로 한칸 이동(D)일 경우, right 스택의 인자를 pop, left 스택에 push
 * 4) 커서 왼쪽 문자 삭제(B)일 경우, left 스택 pop
 * 5) 커서의 왼쪽에 문자 추가(P $)일 경우, left 스택에 $ push
 * 6) 문자열 출력의 경우, left 스택의 bottom부터 top까지 출력 후 right 스택을 차례대로 pop
 * 7) Scanner로 입력받을 경우 시간초과! BufferedReader로 해야함.★★
 */
public class P1406 {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		
		String line = br.readLine();
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<line.length();i++){
			left.push(line.charAt(i));
		}
		
		while(tc-->0){
			String input = br.readLine();
			
			if(input.charAt(0)=='P'){
				left.push(input.charAt(2));
			}
			else if(input.charAt(0)=='L'){
				if(!left.isEmpty())
					right.push(left.pop());
			}
			else if(input.charAt(0)=='D'){
				if(!right.isEmpty())
					left.push(right.pop());
				
			}
			else{//B
				if(!left.isEmpty())
					left.pop();
			}
		}//end while
		
		for(int i = 0;i<left.size();i++){
			System.out.print(left.elementAt(i));
		}
		while(!right.isEmpty()){
			System.out.print(right.pop());
		}
		/*처음에 이렇게 right 스택 print를 하니까 오답이 떴음.
		 * 이유는 pop 시키고 나서 right.size가 변하기 때문에 
		 * 내가 출력하고자 하는 모든 요소를 다 pop하지 못하고 끝남.
		 * 
		 * for(int i = 0;i<right.size();i++){
			System.out.print(right.pop());
		}*/
	}
}
