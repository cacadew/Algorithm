package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 잃어버린 괄호
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 길이가 최대 50인 식을 만들었다.
 * 그리고 나서 세준이는 괄호를 모두 지웠다.그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만드려고 한다.
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 * 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
 * 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리 이상 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.
 * 
 * 접근방법
 * 1) - 바로 뒤를 괄호로 묶으면 뒤에 나오는 +를 -로 바꿀 수 있다. -(A+B) == -A-B
 * 2) 따라서, -가 나오면 그 뒤에 나오는 +를 -로 바꾸어 계산하면 된다! 즉, 수식에 처음 -가 등장하면 그 뒤에 나오는 수들은 모두 - 연산을 한다. (소스코드에 주석참고)
 * 3) 입력값을 쪼갤 때 StringBuilder를 사용하여 연산자와 숫자를 분리한다.(숫자가 몇째자리까지 있는지도 모르고, 연산자가 나올때까지 숫자를 계속 이어붙인다음에 int로 바꿔야해서 String은 비효율)
 * 4) boolean 타입의 변수 b를 선언하여 수식에서 -가 등장했는지 안했는지를 구분한다. -가 등장 했다면 이후 모든 연산은 마이너스, 아직 등장안했다면 +는 덧셈연산을 하고 -가 등장하면 true로 바뀌면서 이후 모든 연산을 뺄셈으로 계산
 */

public class P1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//수식 입력받음
		StringBuilder sb = new StringBuilder();
		
		String line = br.readLine();
		ArrayList<Integer> num = new ArrayList<Integer>(); //int형으로 변환된 숫자를 저장
		ArrayList<Character> op = new ArrayList<Character>(); //연산자만 저장
		
		for(int i = 0; i<line.length();i++){
			char ch = line.charAt(i);
			if((ch != '-') && (ch != '+')){//연산자가 아닐경우 앞에 숫자를 StringBuilder에 추가
				sb.append(ch);
			}
			else{
				num.add(Integer.parseInt(sb.toString())); // 연산자가 나타날경우 지금까지의 StringBuilder를 Integer로 변환하여 ArrayList에 추가
				sb.setLength(0);//길이를 0으로하면서 스트링빌더 초기화!!!
				op.add(ch);//연산자도 ArrayList에 추가
			}
		}
		num.add(Integer.parseInt(sb.toString())); //for문에서 마지막이 연산자가 아니기 때문에 마지막 숫자가 ArrayList에 추가가 안된 상태임. 따라서 한번 더 변환해서 추가
		sb.setLength(0); // 스트링빌더 초기화
		
		int ans = num.get(0);//가장 처음에 오는 숫자를 먼저 저장하고 for문을 돌면서 연산자와 그 다음숫자를 가지고 계산할 예정
		boolean b = false;//괄호 밖이면 false, 괄호 안이면 true
		
		for(int i = 0; i<op.size();i++){
			int n = num.get(i+1);
			char c = op.get(i);
			
			
			if(c == '-' && b == false){// 괄호 밖인데 - 연산자를 만남! 그럼 괄호가 시작되니까 b는 true로 바뀌고, 이후에 모든 +연산은 다 -로 바뀜.
				b = true;  //만약 다시 -가 나오면 그 앞에서 괄호를 닫고, - 뒤에 괄호를 열게 되니까 처음에 한번 -가 나오게되면 그 뒤는 다 -연산을 하게됨
				ans -= n;
			}
			else if(c == '+' && b == false){//아직 - 연산자가 안나왔는데 + 연산자가 나올 경우, 이때는 덧셈을 한다.
				ans += n;
			}
			else if(b == true)//앞에 이미 - 연산자가 나왔을 경우 그 뒤는 모두 마이너스 연산을 한다.
				ans -= n;
			
			
		}
		System.out.println(ans);
		
	}
}
