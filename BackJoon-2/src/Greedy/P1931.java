package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/* 회의실 배정
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 * 
 * 접근방법
 * 1) 먼저 시작하는 것부터, 회의시간이 짧은것부터 할 경우 모두 반례가 존재한다.
 * 2) 이 문제는 일찍 끝나는 회의부터 배정하는 것이다!★★★
 *    이유는 일찍 끝나는 회의를 먼저 배정하게 되면, 남은 회의에 대한 선택의 폭이 커지기 때문이다.
 * 3) 따라서 끝나는 시간을 기준으로 오름차순 정렬을 해준다.
 * 3-1) 주의해야 할 점은, 시작시간에 대한 오름차순 정렬도 필요하다.
 *      예를 들어, (1,1)(1,1)(1,2)(2,2)(2,2) 의 경우 답이 5가 나오지만
 *       (1,1)(1,1)(2,2)(2,2)(1,2) 의 경우 답이 4가 나온다.
 * 4) for문으로 모든회의시간을 돌면서 회의시간이 끝나는 시간을 end 변수에 저장한 후, 시작시간이 end와 같거나 큰 Time을 찾는다.
 * 
 */
class Time{//회의시간을 저장할 객체
	int start;
	int end;
	
	Time(int start, int end){
		this.start = start;
		this.end = end;
	}
}

class ComparatorTime implements Comparator<Time>{//정렬에 필요한 Comparator

	@Override
	public int compare(Time o1, Time o2) {
		// TODO Auto-generated method stub
		if(o1.end > o2.end) // 종료시간이 앞에 객체가 짧을 경우 (짧은게 우선순위가 높음)
			return 1;
		else if(o1.end == o2.end){//종료시간이 같을때는 시작시간을 기준으로 정렬
			if(o1.start > o2.start)
				return 1;
			else
				return -1;
		}
		else
			return -1;
	}
	
}
public class P1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();//회의시간 개수
		int ans = 0;//회의가 배정될 때마다 1씩 증가. 정답을 저장하는 변수
		
		ArrayList<Time> arrT = new ArrayList<Time>();//Time 객체를 저장할 ArrayList
		
		for(int i = 0; i<num;i++){
			int start = Integer.parseInt(sc.next());
			int end = Integer.parseInt(sc.next());
			
			Time t = new Time(start, end);
			arrT.add(t);
		}
		
		Collections.sort(arrT, new ComparatorTime());//정렬
		
		int end = 0; //배정된 회의의 종료시간을 저장할 객체
		
		//정렬된 ArrayList를 돌면서 회의시간을 배정. 이미 오름차순으로 정렬되어 있기 때문에 for문 하나로 끝남
		for(int i = 0; i<num;i++){
			Time time = arrT.get(i); // ArrayList에 저장된 Time객체를 하나 꺼냄
			
			if(end <= time.start){//앞에 진행된 회의의 종료시각보다 시작시각이 크거나 같을 때 배정할 수 있음.
									// 종료시각은 이미 오름차순이기 때문에 현재 값이 가장 빨리 종료하는 회의시간임
				ans++;
				end = time.end; // 배정된 회의시간의 종료시간을 end 값으로 변경
			}
		}
		
		System.out.println(ans);
	}
}
