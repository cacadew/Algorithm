package March5;

import java.util.Scanner;
/*
 * 나무자르기 (이분탐색)
 * 
 * 접근방법
 * : 나무높이의 max값과 min 값의 중간값인 mid로 절단시 구할수 있는 나무의 길이가 원하는 값보다 크면
 * min값을 mid+1로 변경, 원하는 값보다 작을경우 max = mid-1로 변경하여 반복계산
 */
public class P2805 {
	static long[] tree;
	static long m;
	
	static boolean check(long h){
		long tempSum = 0;
		for(int i = 0; i<tree.length;i++){
			if(tree[i] >=h)
				tempSum = tempSum + tree[i] - h;
		}
		
		return tempSum >=m;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.next());
		m = Long.parseLong(sc.next());
		
		tree = new long[n];
		
		long min = 0;
		long max = 0;
		for(int i = 0; i<n;i++){
			tree[i] = Long.parseLong(sc.next());
			max = Math.max(max, tree[i]);
		}
		
		long mid;
		while(min <= max){
			mid = (min+max)/2;
			if(check(mid)){//mid높이로 절단했을 때, 가져가는 나무 길이가 m보다 클때
				min = mid+1;
			}else{
				max = mid-1;
			}
		}
		
		System.out.println(min-1);		
	}
}
