package swea.d3;

import java.util.Scanner;

public class 다솔이의다이아몬드장식 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		char[][] diamond = {
				{'.', '.', '#', '.', '.'},
				{'.', '#', '.', '#', '.'},
				{'#', '.', ' ', '.', '#'},
				{'.', '#', '.', '#', '.'},
				{'.', '.', '#', '.', '.'}
		};
		
		for(int testCase = 1; testCase <= T; testCase++) {
			String str = sc.next();
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < str.length(); j++) {
					int startPoint = (j == 0) ? 0 : 1;
					for(int k = startPoint; k < 5; k++) {
						if(i == 2 && k == 2) sb.append(str.charAt(j));
						else sb.append(diamond[i][k]);
					}
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

}
