import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoDots16929 {

	static int N, M;
	static char[][] map;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		boolean result = false;
		outer: for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 하나라도 사이클을 찾을 경우(true) 반복문 종료
				visited[i][j] = true;
				if(DFS(i, j, 1, i, j)) {
					result = true;
					break outer;
				}
			}
		}
		
		System.out.println((result) ? "Yes" : "No");
	}

	private static boolean DFS(int r, int c, int k, int sr, int sc) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 범위 벗어나면 pass
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			
			// 같은 색이 아니라면 pass
			if(map[nr][nc] != map[r][c]) continue;

			if(visited[nr][nc]) {
				// 사이클이라면 true
				if(k >= 4 && (nr == sr && nc == sc)) return true;
				// 이미 방문한 곳은 pass
				else continue;
			}
			
			// 사이클인 경우 true 리턴하고 종료함
			visited[nr][nc] = true;
			if(DFS(nr, nc, k+1, sr, sc)) return true;
			visited[nr][nc] = false;
		}
		return false;
	}
}
