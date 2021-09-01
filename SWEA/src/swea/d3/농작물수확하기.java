package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			// 정사각형 마름모의 성질을 이용하자!
			// 마름모는 중심으로부터 모든 변까지의 거리가 같다!
			// 즉 중심과 (i, j)와의 거리가 마름모의 거리보다 작거나 같다면 마름모 범위 안이다.
			int point = N / 2;
			int benefit = 0;	// 수익
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(Math.abs(point - i) + Math.abs(point - j) <= point) benefit += map[i][j];
				}
			}
			sb.append("#" + testCase + " " + benefit + "\n");
		}
		System.out.println(sb);
	}

}
