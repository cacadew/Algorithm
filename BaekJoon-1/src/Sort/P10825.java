package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/* 국영수 - 점수별로 오름,내림차순 & 이름으로 내림차순
 * 
 * 접근방법
 * 1) 똑같이 Comparator 재정의 해서 사용.
 * 2) String을 비교할 경우, [str1.compareTo(str2)]을 사용한다.
 * 3) boolean 값으로 리턴됨. if(str1.compareTo(str2)>0) 이 true 이면, str2가 사전편찬순으로 앞에 있고 str1이 뒤에 있는것
 * 4) 반대로 str1.compareTo(str2)<0 이면, str1이 앞에 str2가 뒤에 오게된다.(compareTo()안에 파라미터를 기준으로 생각하면 됨)
 */
class Score{
	String name;
	int kor;
	int eng;
	int math;
	Score(String name, int kor, int eng, int math){
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
}
class ComparatorScore implements Comparator<Score>{

	@Override
	public int compare(Score o1, Score o2) {
		// TODO Auto-generated method stub
		if(o1.kor < o2.kor){
			return 1;
		}
		else if(o1.kor == o2.kor){
			if(o1.eng > o2.eng){
				return 1;
			}else if(o1.eng == o2.eng){
				if(o1.math < o2.math){
					return 1;
				}else if(o1.math == o2.math){
					if(o1.name.compareTo(o2.name)>0){//문자열비교!!! true이면, o2.name이 앞에 위치하고 o1.name이 뒤에 위치
						return 1;
					}else{
						return -1;
					}
				}//math- else
				else
					return -1;
			}//eng - else
			else
				return -1;
		}//kor - else if
		else
			return -1;
	}
	
}
public class P10825 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		ArrayList<Score> s = new ArrayList<Score>();
		
		while(num-->0){
			String name = sc.next();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();
			
			s.add(new Score(name,kor,eng,math));
		}
		
		Collections.sort(s,new ComparatorScore());
		
		for(int i = 0; i<s.size();i++){
			System.out.println(s.get(i).name);
		}
		
		
	}
}
