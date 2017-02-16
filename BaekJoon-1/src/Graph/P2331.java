package Graph;

import java.util.Scanner;

/* 반복수열
 * 다음과 같이 정의된 수열이 있다.
 * D[1] = A
 * D[n] = D[n-1]의 각 자리의 숫자를 P번 곱한 수들의 합
 * 예를 들어 A=57, P=2일 때, 수열 D는 {57, 74(=5^2+7^2=25+49), 65, 61, 37, 58, 89, 145, 42, 20, 4, 16, 37, …}이 된다.
 * 그 뒤에는 앞서 나온 수들(57부터가 아니라 58부터)이 반복된다.
 * 이와 같은 수열을 계속 구하다 보면 언젠가 이와 같은 반복수열이 된다. 이 때, 반복되는 부분을 제외했을 때, 수열에 남게 되는 수들의 개수를 구하는 프로그램을 작성하시오.
 * 위의 예에서는 {57, 74, 65, 61}의 네 개의 수가 남게 된다.
 * 
 * 접근방법
 * 1) check[]의 형태를 바꿔주변 된다. 인덱스를 수열의 수 이고, 각 배열 값은 해당 인덱스가 몇번째에 나타나는지를 저장하면 된다.
 * 2) 만약 계산된 D[n]이 check[D[n]]의 값이 0이 아닐경우 이미 앞에 나왔던 수임을 알 수 있으므로 반복의 시작점이라고 판단한다.
 * 3) 따라서 check배열의 값 -1 이 반복이 되지 않고 남게되는 수의 개수이다.
 */
public class P2331 {
	static int[] check = new int[1000000];
	
	//각 자리수 마다 p제곱 값을 구하는 메소드
	static int pow(int a, int p){
		int ret = 1;
		for(int i = 0; i<p;i++){
			ret = ret * a;
		}
		return ret;
	}
	
	//자릿수를 나누어 p제곱하여 다음 수열의 수를 구하는 메소드
	static int calc(int a, int p){
		int ret = 0;
		
		while(a>0){
			ret += pow(a%10, p);//1의자리부터 시작!
			a /=10;
		}
		
		return ret;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int p = sc.nextInt();
		
		boolean b = true;//반복되는 지점을 만나면 false로 바뀜
		check[a] = 1; // 처음 시작하는 수의 인덱스를 넣어두고 while문 시작하려고
		int index = 2; // while문에서 계산되는 것은 인덱스가 2부터!
		int num = 0; // 다음 수열의 수
		
		while(b){
			num = calc(a,p); //다음 수열의 수가 계산됨.
			a = num;//다음 while문에 사용하기 위해 a에 num을 저장
			if(check[num] == 0){//처음 나온 수
				check[num] = index++;//몇번째 나온 수 인지 check에 저장 후 1증가
			}else{//이미 나왔던 수이므로, 해당지점부터 반복이 시작됨을 알 수 있다.
				b = false;//b를 false로 바꾸고 while문을 빠져나온다.
			}
		}
		System.out.println(check[num]-1);
	}
}
