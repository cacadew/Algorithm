package Sort;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
/*
 * 카드
 * 준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오.
 * 만약, 가장 많이 가지고 있는 정수가 여러가지라면, 작은 것을 출력한다.
 * 
 * 접근방법
 * 1)HashMap을 사용해서 카드번호를 K, 카드 개수를 V로 한다.
 * 2)새로운 카드가 나오면 hash.put , 이미 존재하는 카드가 나오면 카드번호로 V를 찾아 +1을 해준다.
 * 3)Iterator로 hashMap을 돌면서 V가 가장 큰값의 K를 찾아 출력한다.
 */
public class P11652 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		// K : 카드번호    V : 카드가 나온 횟수
		HashMap<Long, Integer> hash = new HashMap<Long, Integer>();//카드번호가 int의 범위를 넘어가기 때문에 Long으로 선언
		
		while(tc-->0){
			Long cardNum = sc.nextLong();
			if(!hash.containsKey(cardNum)){//카드번호가 hash에 없으면 V는 1로 put
				hash.put(cardNum, 1);
			}else{// 있다면 기존의 값을 불러와서 V+1
				hash.put(cardNum, hash.get(cardNum)+1);
			}
		}
		int max = 0; //V가 가장 큰 K를 찾기위해 사용할 변수
		Long key = 0L; // V가 가장 큰 K를 저장할 변수
		
		Iterator<Long> it = hash.keySet().iterator();
		while(it.hasNext()){
			Long k = it.next();
			int v = hash.get(k);
			if(max < v){
				max = v;
				key = k;
			}else if(max == v){ //문제에서 횟수가 같을경우 카드번호가 작은걸 출력하라는 조건이 있었음
				if(k < key){
					key = k;
				}
			}
		}
		System.out.println(key);
	}
}
