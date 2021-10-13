package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 디저트카페 {
	
	static int N;
	static int[][] map;
	// 대각선 시계방향 검사: 우하, 좌하, 좌상, 우상
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, -1, 1};
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = -1;
			visited = new boolean[101];		// 디저트 수만큼 visited
			for(int i = 0; i < N - 2; i++) {
				for(int j = 1; j < N - 1; j++) {
					// 각각의 점에서 DFS를 돌아서 경로가 있는지 본다.
					visited[map[i][j]] = true;
					DFS(i, j, i, j, 0);
					// DFS 종료 후 visited 초기화는 필수!
					visited[map[i][j]] = false;
				}
			}
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.println(sb);
	}

	private static void DFS(int r, int c, int sr, int sc, int dir) {
		// 현재 방향과 다음 방향에 대하여
		for(int d = dir; d <= dir + 1 && d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 맵 범위 안일 때
			if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
				// 시작 지점과 만났을 경우엔 현재까지의 디저트 개수를 세서 Max값 갱신
				if(nr == sr && nc == sc) {
					int cnt = 0;
					for(int i = 1; i <= 100; i++) {
						if(visited[i]) cnt++;
					}
					result = Math.max(result, cnt++);
					return;
				}
				
				// 방문할 수 있는 디저트 가게를 방문하자!
				if(!visited[map[nr][nc]]) {
					visited[map[nr][nc]] = true;
					DFS(nr, nc, sr, sc, d);
					visited[map[nr][nc]] = false;
				}
			}
		}
	}

}
