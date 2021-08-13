package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Magnetic {

	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int T = 1; T <= 10; T++) {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			cnt = 0;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				int cntN = 0;
				for(int j = 0; j < N; j++) {
					// N극과 S극이 만날 때를 교착 상태라고 본다.
					// N극이 ↓ 방향, S극이 ↑ 방향으로 진행되므로
					// N극이 1개 이상인 상황에서 S극을 만나면 교착상태 + 1
					if(board[j][i] == 1) cntN++;
					else if(board[j][i] == 2 && cntN > 0) {
						cnt++;
						cntN = 0;
					}
				}
			}
			
			sb.append("#" + T + " " + cnt + "\n");
		}
		System.out.println(sb);

	}

}
