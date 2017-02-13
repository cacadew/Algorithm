package Sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/* 좌표정렬하기
 * 입력되는 x좌표, y좌표가 한 쌍이다. x좌표를 기준으로 오름차순 정렬을 하고
 * 만약 같은 수가 있다면 이때는 y값을 기준으로 오름차순하라!
 * 
 * 접근방법
 * 1) Point라는 객체에 x좌표와 y좌표를 넣고, 이를 저장하는 ArrayList를 만든다.
 * 2) 객체로 만들어서 정렬하는 것이 x와 y를 함께 움직일 수 있어서 좋음
 * 3) Comparator을 오버라이딩 하여 재정의 한다.
 * 4) Collections(p, new ComparatorY()); 로 조건에 맞게 정렬하면 된다.
 * 
 * 참고
 * - 우선순위 큐를 사용했을 때 재정의한 Comparator를 사용하는 방법
 *  PriorityQueue<Point> q = new PriorityQueue<Point>(new ComparatorY());
 */
class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class ComparatorY implements Comparator<Point>{

	@Override
	public int compare(Point o1, Point o2) {
		// TODO Auto-generated method stub
		if(o1.x > o2.x){
			return 1;
		}else if( o1.x == o2.x){//x좌표가 같을 때
			if(o1.y > o2.y){ // o1의 y가 크다면 그대로
				return 1;
			}
			else{//o2의 y가 크다면 반대로
				return -1;
			}
		}else//o1.x <= o2.x 일때
			return -1;
	}
	
}
public class P11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		ArrayList<Point> p = new ArrayList<Point>();// 좌표 객체 Point를 저장할 ArrayList
		
		for(int i = 0;i<size;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			p.add(new Point(x,y));
		}
		
		Collections.sort(p, new ComparatorY()); // 재정의한 ComparatorY를 생성하여 정렬
		
		for(int i = 0;i<p.size();i++){
			System.out.println(p.get(i).x+" "+p.get(i).y);
		}
		
		
		
		
		
		
		
	}
}
