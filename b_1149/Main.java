package b_1149;

import java.util.Scanner;

public class Main {
	
	static int N;
	
	static int[][] map = new int[1001][3];
	static int[][] value = new int[1001][3];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		int compare = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				map[i][j] = scan.nextInt();
				
				if(i==1) {
					value[i][j] = map[i][j];
				}else {
					compare = Math.min(value[i-1][1], value[i-1][2]);
					value[i][0] = map[i][0] + compare;
					
					compare = Math.min(value[i-1][0], value[i-1][2]);
					value[i][1] = map[i][1] + compare;
					
					compare = Math.min(value[i-1][0], value[i-1][1]);
					value[i][2] = map[i][2] + compare;
				}
			}
		}
		
		int min = Math.min(value[N][0], value[N][1]);
		min = Math.min(min, value[N][2]);
		
		System.out.println(min);
		
		scan.close();
	}
}
