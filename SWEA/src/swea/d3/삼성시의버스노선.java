package swea.d3;

import java.util.Scanner;

public class 삼성시의버스노선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] bus = new int[5001];	// 버스 노선의 개수
			// 입력
			for(int i = 0; i < N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				for(int j = a; j <= b; j++) {
					bus[j]++;
				}
			}
			
			// C개의 버스 정류장에 얼마나 많은 노선이 다니는지 출력
			int C = sc.nextInt();
			sb.append("#" + testCase);
			for(int i = 0; i < C; i++) {
				int c = sc.nextInt();
				sb.append(" " + bus[c]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
