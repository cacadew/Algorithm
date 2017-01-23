import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Picnic {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i<testcase;i++){
			int stuNum = sc.nextInt();
			int coupleNum = sc.nextInt();
			
			boolean[] stuCheck = new boolean[stuNum];
			for(int j = 0; j<stuCheck.length;j++){
				stuCheck[j] = false;
			}
			int[][] friendTable = new int[coupleNum][2];
			
			for(int j=0;j<coupleNum;j++){
				friendTable[j][0] = sc.nextInt();
				friendTable[j][1] = sc.nextInt();
			}
			findPair(friendTable,stuCheck);
			
			int fac=1;
			for(int j = 1;j<=stuNum/2;j++){
				fac = fac * j;
			}
			
			result.add(cnt/fac);
			cnt = 0;
			//System.out.println(findPair(friendTable,stuCheck,cnt,coupleNum));
		}
		
		for(int i = 0; i<result.size();i++){
			System.out.println(result.get(i));
		}
	}
	
	
	
	static void findPair(int[][] friendTable, boolean[] stuCheck){
		int check = 0;
		for(int j = 0; j<stuCheck.length;j++){
			if(stuCheck[j] == true)
				check++;
			else
				break;
		}
		if(check == stuCheck.length){
			cnt++;
			return;
		}
		
		for(int k = 0; k <friendTable.length;k++){
			if(stuCheck[ friendTable[k][0] ] == false && stuCheck[ friendTable[k][1] ] == false){
				stuCheck[ friendTable[k][0] ] = true;
				stuCheck[ friendTable[k][1] ] = true;
						
				findPair(friendTable, stuCheck);
						
				stuCheck[ friendTable[k][0]] = false;
				stuCheck[ friendTable[k][1]] = false;
				}
			}
		
	}
}
