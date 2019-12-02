package b_10844;

import java.util.Scanner;

public class Main {
	
	static long[][] map = new long[10][101];
	
	static int N;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		long sum = 0;
		
		for(int i=1; i<=9; i++) {
			map[i][1] = 1;
		}
		
		for(int j=2; j<=N; j++) {
			for(int i=0; i<=9; i++) {
				
				if(i == 0) {
					map[i][j] = (map[i+1][j-1] % 1000000000);
				}else if(i == 9) {
					map[i][j] = (map[i-1][j-1] % 1000000000);
				}else {
					map[i][j] = (map[i-1][j-1] + map[i+1][j-1])%1000000000;
				}
				
			}
		}
		
		for(int i=0; i<=9; i++) {
			sum += map[i][N];
		}
		
		System.out.println((sum%1000000000));
		
		scan.close();
	}

}
