package DataStructure1;

import java.util.Scanner;

/*ROT13 문제
 * ROT13은 카이사르 암호의 일종으로 영어 알파벳을 13글자씩 밀어서 만든다.
 * 접근방법
 * 1) 아스키 코드 값을 사용해 A~N , M~Z를 나누어 if문을 사용한다.
 * 2) A~N(a~n)은 가지고 있는 아스키값에 +13을 바로 해준다.
 * 3) M~Z는 +13을 해줬을대 Z를 넘어가게 되면 다시 A로 돌아가서 카운트를 해줘야 하기 때문에 예외처리가 필요하다.
 * 4) 3)의 경우 letter 값에서 알파벳 13번째인 'M'을 빼준 후(Z를 넘어서는 카운트), 'A'를 더해주고 +1을 하면 된다.
 * 5) 알파벳 이외의 띄어쓰기나 숫자는 변환이 필요하지 않으므로, else 부분에  ans = letter; 이라는 코드가 필요하다.
 */
public class P11655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		
		for(int i = 0; i<line.length();i++){
			char ans='\0';					//The character '\0' is the null character. 
			char letter = line.charAt(i);
			if(letter==' '){
				ans = ' ';
			}
			else if(letter<='m' && letter>='a'){
				ans = (char)(letter+13);
			}
			else if(letter<='M' && letter>='A'){
				ans = (char)(letter+13);
			}
			else if(letter>'M' && letter<='Z'){
				ans = (char)(letter-'M'+'A'-1);
			}
			else if(letter >'m' && letter<='z'){
				ans = (char)(letter-'m'+'a'-1);
			}
			else
				ans = letter;
			System.out.print(ans);
		}
	}
}
