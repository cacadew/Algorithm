package Sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/* 좌표 정렬하기2
 * 입력되는 x좌표, y좌표가 한 쌍이다. y좌표를 기준으로 오름차순 정렬을 하고
 * 만약 같은 수가 있다면 이때는 x값을 기준으로 오름차순하라!
 * 
 * 접근방법 -P11650 참고
 * 1) 우선순위 큐를 사용했음. Comparator 재정의하여 사용
 */
class Point2{
	int x;
	int y;
	Point2(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class ComparatorXY implements Comparator<Point2>{

	@Override
	public int compare(Point2 o1, Point2 o2) {
		// TODO Auto-generated method stub
		if(o1.y > o2.y){
			return 1;
		}
		else if(o1.y == o2.y){
			if(o1.x >= o2.x){
				return 1;
			}
			else
				return -1;
		}
		else
			return -1;
	}
	
}
public class P11651 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		PriorityQueue<Point2> q = new PriorityQueue<Point2>(new ComparatorXY());
		
		while(size-->0){
			int x = sc.nextInt();
			int y = sc.nextInt();
			q.add(new Point2(x,y));
		}
		
		while(!q.isEmpty()){
			Point2 popped = q.poll();
			System.out.println(popped.x+" "+popped.y);
		}
		
	}
}
