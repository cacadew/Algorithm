package Graph;

import java.util.Scanner;
/* Term Project
 * 팀 프로젝트를 한다. 각 정점을 학생으로 생각했을 때, 각 정점은 같은 팀을 하고 싶은 정점 하나를 선택할 수있다.
 * 사이클이 완성되면 한 조가 완성이된다. 사이클에 속하지 못할 경우 어느 팀에도 속하지 않는 것이다.
 * 이때 어느 프로젝트 팀에도 속하지 않는 학생들의 수를 계산하라
 * 예)
7 //학생수
3 1 3 7 3 4 6 //인덱스가 정점이고 해당 값이 가르키는 정점

이때, 3은 혼자 팀(사이클이 되니까) / 4,6,7 팀 이렇게 2팀이 구성되고 1,2,5는 팀에 속하지 않는다.
따라서 답은 3


 * 
 * 접근방법
 * 1) 그동안 이미 방문한 점을 재방문 했을 때 무조건 사이클이었다. 하지만 이문제에서는 다름!!
 * 2) 한번 순회를 하는 것을 한 step이라고 할때, 순회 중 이미 방문한 점을 발견했을 때 같은 step을 가지고 있어야만 사이클이 된다.
 * 3) 각 정점을 방문할때마다 step 번호와, 한 스텝에서 방문순서를 각각 step[]과 d[]에 저장한다. 방문한적이 없으면 d[i]는 0
 * 4) 순회 중 재방문한 정점을 만나면, step을 비교해서 같은 사이클인지 확인 후, 현재의 cnt 값에서 d[i]에 저장된 cnt값을 빼면 한 조에 구성된 학생수 (정점 개수)를 알 수있다.
 * 
 * 어려우니까... 다시한번 풀어보도록
 *  
 */
public class P9466 {
	static int[] arr;// 해당 정점이 가르키는 정점을 저장
	static int[] d; // 한 step에서 몇번째 방문인지를 저장. 한 사이클에 몇개의 정점이 있는지를 알기 위해 사용.
	static int[] step; // 같은 사이클인지를 구분하는 배열
	
	static int find(int v, int cnt, int s){
		if(d[v] != 0){//재방문한 정점
			if(step[v] == s){//step이 같으면 같은 사이클
				return cnt - d[v]; // 현재는 1증가된 cnt를 가지고 있음. cnt-d[v]를 할때, 해당 사이클에 구성된 정점의 개수를 알 수있음.
			}
			else{//다른 사이클이므로 0 return
				return 0;
			}
		}
		
		d[v] = cnt;//방문 순서 저장
		step[v] = s;//step 저장
		return find(arr[v],cnt+1,s); //v가 가르키는 정점, cnt증가, step 수를 파라미터로 재귀
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		while(tc-->0){
			int vNum = sc.nextInt();
			arr = new int[vNum+1];
			d = new int[vNum+1];
			step = new int[vNum+1];
			
			for(int i = 1;i<arr.length;i++){
				arr[i] = sc.nextInt();
			}
			
			int ans = 0;
			
			for(int i = 1; i<arr.length;i++){
				if(d[i] == 0){
					ans += find(i,1,i);//사이클로 묶인 정점들의 값을 ans의 누적. 전체 정점 개수에서 ans를 빼서  사이클로 구성되지 않은 정점의 개수를 구함
				}
				
			}
			System.out.println(vNum-ans);
		}
		
		
	}
}
