package March5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/* 영역구하기
 * MxN 사각형이 있고 K개의 직사각형으로 내부를 분리한다.
 * 직사각형의 내부를 제외한 나머지 부분이 몇개의 영역으로 분리되는지, 각 영역의 크기를 오름차순으로 출력해라.
 * 
 * 접근방법
 * 1) 입력값은 배열의 인덱스처럼 상단좌측부터 번호가 시각되지않고, 하단좌측부터 시작한다.
 * 1-1) 따라서 입력받는 x, y가 배열 map[y][x] 이렇게 입력되면 평소 익숙한 배열이 되므로 이렇게 입력값을 받는다.
 * 1-2) y1,x1,y2,x2 이렇게 입력을 받을때 이중for문을 사용해서 x2-x1만큼돌면서 y2-y1만큼 인덱스를 증가시켜 사각형 내부를 -1로 체크한다.
 * 2) 배열 map과 똑같은 d[][]를 만든다.(cache)
 * 3) 0,0부터 map배열을 순회한다.
 * 3-1) map[][]==0, d[][]==0이면 빈 영역이 시작되는 것이므로 bfs()를 시작한다.
 * 4)bfs()를 거치면서 해당 위치와 연결된 빈 영역을 체크할 수 있다.
 * 4-1)cnt값을 넣어줬는데 이건 빈 영역이 몇개 나왔는지 카운트하기위해 사용, 나중에 빈 영역의 크기를 세야하니까
 * 5)모든 영역을 체크한 후 cnt만큼의 width배열(1차원)을 만든다. for문으로 d[][]를 순회하며 1이 표시되어 있으면 width[0]++를 해준다.
 * 6)width를 오름차순 정렬 후 출력
 * 
 *  처음 시간초과가 났던 이유는, bfs()에서 q.add(nx,ny)를 할때 d[][]에 체크를 안하고, 나중에 pop될때만 체크를 했더니
 *  for문을 돌때 이미 큐에 넣어둔 위치인데도 다시 큐에 넣어지면서 계속 반복문을 돌았다.
 *  무조건 체크하고 나서 큐에 넣어야함.
 * (백준-1>Graph>P2667 단지번호붙이기 문제와 비슷)
 */
public class P2653 {
	static final int[] dx = {0,0,-1,1};
	static final int[] dy = {1,-1,0,0};
	static int[][] map;
	static int[][] d;
	static int cnt = 0;
	
	static void bfs(int startX, int startY){
		Queue<Integer> q = new LinkedList<Integer>();
		d[startX][startY] = cnt;//bfs 요소 큐에 push하기전에!!! 체크해야함. 그래야지 밑에 for문 돌때 이미 체크한곳은 큐에 다시 안넣게 할수있음
		q.add(startX);
		q.add(startY);
		
		while(!q.isEmpty()){
			int x = q.poll();
			int y = q.poll();
			
			
			for(int i = 0; i<4;i++){
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0&& nx<map.length && ny>=0 && ny<map[0].length){
					if(map[nx][ny] == 0 && d[nx][ny] == 0){
						d[nx][ny] = cnt;//큐에 넣기전 d[][]체크
						q.add(nx);
						q.add(ny);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = Integer.parseInt(sc.next());
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		
		map = new int[m][n];
		d = new int[m][n];
		
		while(k-->0){
			int y1 = Integer.parseInt(sc.next());
			int x1 = Integer.parseInt(sc.next());
			
			int y2 = Integer.parseInt(sc.next());
			int x2 = Integer.parseInt(sc.next());
			
			for(int i = 0; i<x2-x1;i++){
				for(int j = 0; j<y2-y1;j++){
					map[x1+i][y1+j] = -1;
					d[x1+i][y1+j] = -1;
				}
			}	
		}//end while
		
		//분리된 영역을 찾아서 bfs()
		for(int i = 0; i<m;i++){
			for(int j = 0; j<n;j++){
				if(map[i][j] == 0 && d[i][j] == 0){
					cnt++;
					bfs(i,j);
				}
			}
		}
		System.out.println(cnt);//분리된 영역 개수 출력
		int[] width = new int[cnt];//분리된 영역의 개수만큼 배열을 만들어줌. 각 영역의 크기를 저장하기위해
		
		//d[][]를 순회하면서 각 영역의 크기를 구함 d[i][j]가 1이면 width[0]++, d[i][j]가 3이면 width[2]++
		for(int i = 0;i<m;i++){
			for(int j = 0; j<n;j++){
				if(d[i][j] >0) width[d[i][j]-1]++;
			}
		}
		Arrays.sort(width);//오름차순 정렬 후 출력
		for(int i = 0; i<cnt;i++){
			System.out.print(width[i]+" ");
		}
		
	}
}
