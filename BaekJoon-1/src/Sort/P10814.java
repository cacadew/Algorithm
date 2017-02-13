package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/* 나이순 정렬
 * 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
 * 이 때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
 * 
 * 접근방법
 * 1) MemberList 객체에 나이, 이름, 가입순서를 담는다.
 * 2) ArrayList에 객체를 담고, Comparator 재정의를 통해 정렬한다.
 * 3) Comparator에서 나이로 먼저 비교를 하고, 같을 경우 seq를 비교
 * 4) 주의주의 ★★ Comparator에서 비교를 하는 것은 각 숫자값의 크기가 아니라! 우선순위를 비교하는 것
 * 5) 따라서 숫자가 작은게 우선순위가 높다. o1.age > o2.age가 참이라면 o1.age가 숫자가 더 작아 우선순위가 높은것이므로 return 1하면 오름차순 정렬됨
 */
class MemberList{
	int age;	//회원 나이
	String name; //회원 이름
	int seq;	//가입순서
	
	public MemberList(int age, String name, int seq) {
		this.age = age; 
		this.name = name;
		this.seq = seq;
	}
}

class ComparatorMember implements Comparator<MemberList>{

	@Override
	public int compare(MemberList o1, MemberList o2) {
		// TODO Auto-generated method stub
		if(o1.age > o2.age){// 여기서 비교하는 것은 age값이 아니라, o1.age와 o2.age의 우선순위를 비교하는 것임!!
			return 1;//숫자 작은게 우선순위 높은거니까 return 1
		}
		else if(o1.age == o2.age){
			if(o1.seq >= o2.seq){//숫자가 작은게 우선순위가 높은것!! 따라서 seq가 작을 수록 먼저 가입해서 우선순위가 높은거니까 return 1
				return 1;
			}
			else{
				return -1;
			}
		}
		else
			return -1;
	}
	
}
public class P10814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		ArrayList<MemberList> m = new ArrayList<MemberList>();
		
		int seq = 1;
		while(tc-->0){
			int age = sc.nextInt();
			String name = sc.nextLine();
			m.add(new MemberList(age, name, seq++));//먼저 입력되면 우선순위가 높은 seq(가입순서)를 갖게된다.
		}
		
		Collections.sort(m, new ComparatorMember());
		
		for(int i = 0;i<m.size();i++){
			MemberList popped = m.get(i);
			System.out.println(popped.age+""+popped.name);
		}
	}
}
