package swea.d3;

import java.util.Scanner;

public class 동철이의프로그래밍대회 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int max = Integer.MIN_VALUE;
			int maxCnt = 0;
			for(int i = 0; i < N; i++) {
				int cnt = 0;
				for(int j = 0; j < M; j++) {
					int score = sc.nextInt();
					if(score == 1) cnt++;
				}
				
				if(cnt > max) {
					max = cnt;
					maxCnt = 1;
				} else if(cnt == max) maxCnt++;
			}
			
			sb.append("#" + testCase + " " + maxCnt + " " + max + "\n");
		}
		
		System.out.println(sb);

	}

}
