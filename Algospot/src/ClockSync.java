import java.util.ArrayList;
import java.util.Scanner;


public class ClockSync {
	static int[][] linked ={
		{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,0},
		{0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1},
		{1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,1,1,1,0,1,0,1,0,0,0},
		{1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
		{0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1},
		{0,0,0,0,1,1,0,1,0,0,0,0,0,0,1,1},
		{0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,1,1,1,0,0,0,1,0,0,0,1,0,0}
	};
	static int SWITCHES = 10;
	static int CLOCKS = 16;
	static int[] clocks = new int[16];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		ArrayList<Integer> resultArr = new ArrayList<Integer>();
		
		for(int i = 0; i<testcase;i++){
			
			
			for(int j = 0; j<clocks.length;j++){
				clocks[j] = sc.nextInt();
			}//clock 입력 완료
			
			int result = solve(clocks,0);
			if(result == 999)
				result = -1;
			
			resultArr.add(result);
		}
		
		for(int i = 0; i<resultArr.size();i++){
			System.out.println(resultArr.get(i));
		}
		
		
	}//end main
	
	
	
	
	static boolean areAligned(int[] clocks){
		int cnt=0;
		for(int i = 0; i<clocks.length;i++){
			if(clocks[i] == 12)
				cnt++;
		}
		if(cnt == CLOCKS)
			return true;
		else
			return false;
	}
	
	static void push(int[] clocks, int swtch){
		for(int clock = 0; clock<CLOCKS;clock++){
			if(linked[swtch][clock] == 1){
				clocks[clock] += 3;
				if(clocks[clock] == 15)
					clocks[clock] = 3;
			}
		}
	}
	
	
	static int solve(int[] clocks, int swtch){
		if(swtch == SWITCHES)
			return areAligned(clocks) ? 0 : 999;
		
		int ret = 999;
		for(int cnt = 0; cnt<4; cnt++){
			ret = Math.min(ret,cnt+solve(clocks, swtch+1));
			push(clocks,swtch);
		}
		
		
		return ret;
	}
}
