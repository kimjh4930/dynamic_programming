package b_2579;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
	
	static int N;
	static int[] score = new int[301];
	static List<String>[] stringList = new ArrayList[301];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		stringList[0] = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			score[i] = scan.nextInt();
			stringList[i] = new ArrayList<>();
		}
		
		stringList[1].add("1");
		stringList[2].add("2");
		stringList[2].add("11");
		
		String str = "";
		
		func(N);
		
		for(int i=1; i<=N; i++) {
			System.out.println(maxofSum(i));
		}
		
//		for(int i=1; i<=N; i++) {
//			for(String s : stringList[i]) {
//				System.out.print(s + ", ");
//			}
//			System.out.println("");
//		}
		
		scan.close();
	}
	
	static int maxofSum (int N) {
		int max = -1;
		int sum = 0;
		int stairs = 0;
		
		for(String s : stringList[N]) {
			
			stairs = 0;
			sum = 0;
			
			System.out.print("Stairs : ");
			
			for(int i=0; i<s.length(); i++) {
				stairs += s.charAt(i) - '0';
				System.out.print(stairs + " ");
				sum += score[stairs];
				
			}
			
			System.out.println("sum : " + sum);
			
			max = Math.max(max, sum);
		}
		
		return max;
	}
	
	static List<String> func (int num) {
		
		if(num == 1) {
			return stringList[1];
		}else if(num == 2) {
			return stringList[2];
		}else {
			
			if(stringList[num].size() != 0) {
				return stringList[num];
			}
			
			List<String> num1List = func(num-1);
			
			for(int i=0; i<num1List.size(); i++) {
				
				//직전 두개의 값이 1, 1 이라
				if(num1List.get(i).length() >= 2) {
					
					char c1 = num1List.get(i).charAt(num1List.get(i).length()-1);
					char c2 = num1List.get(i).charAt(num1List.get(i).length()-2);

					if(c1 == '1' && c2 == '1') {
						continue;
					}
					
					if(c1 == '1' && c2 == '2') {
						continue;
					}
				}
				
				//그렇지 않으면 현재 문자열에 1을 추가해서 stringList[num] 에 저장한다.
				stringList[num].add(num1List.get(i) + "1");
				
			}
			
			List<String> num2List = func(num-2);
		
			for(int i=0; i<num2List.size(); i++) {
				stringList[num].add(num2List.get(i) + "2");
			}
			
			return stringList[num];
		}
	}

}
