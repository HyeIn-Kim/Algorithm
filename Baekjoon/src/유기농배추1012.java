import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오랜만에 푼 DFS 문제.
// 3분만에 금방 풀 줄 알았는데 의외로 조금 헤맸다.
public class 유기농배추1012 {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				// 배추 위치를 1로 변경하고
				map[r][c] = 1;
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					// 아직 방문 안한 배추 = 새 배추 무리 시작이므로 DFS 탐색
					// 배추벌레가 갈 수 있는 배추를 모두 DFS로 돌고온다.
					if(map[i][j] == 1 && !visited[i][j]) {
						DFS(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);
	}

	private static void DFS(int r, int c) {
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 범위 벗어나면 pass
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			// 배추가 없는 칸은 pass
			if(map[nr][nc] == 0) continue;
			// 이미 벌레가 있는 칸은 pass
			if(visited[nr][nc]) continue;
			
			DFS(nr, nc);
		}
	}

}
