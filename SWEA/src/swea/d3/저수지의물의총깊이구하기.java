package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 저수지의물의총깊이구하기 {

	static int N;			// 저수지 한 변의 길이
	static char[][] map;	// 저수지
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			// 입력
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			int max = Integer.MIN_VALUE;		// 가장 깊은 곳 저장
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 현재 위치가 Water이라면 주변 8방향을 살펴보고 깊이를 잰다.
					if(map[i][j] == 'W') {
						int cnt = cntWater(i, j);
						// 현재 위치가 가장 깊으면 max 교체
						if(cnt > max) max = cnt;
					}
				}
			}
			sb.append("#" + testCase + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	// 8방향 검사
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

	private static int cntWater(int r, int c) {
		int cnt = 0;
		for(int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 다음 위치가 배열 범위에서 벗어나면 continue하고
			// Water의 개수를 센다.
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(map[nr][nc] == 'W') cnt++;
		}
		// 8방향 다 Water가 아니면 깊이는 1이므로 1 반환
		// 아니라면 Water 수만큼 깊이 반환
		return (cnt == 0) ? 1 : cnt;
	}

}
