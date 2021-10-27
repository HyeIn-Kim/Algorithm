import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ... 로직은 다맞아놓고 cnt 초기화를 안했다..
public class 빙산2573 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 1;
		while(true) {
			cnt = 0;
			// 빙산을 녹이고
			melt();
			// 빙산이 남아있으면 종료
			if(cnt == 0) break;
			
			// 빙산이 하나 남아있는지 확인하기: DFS
			// 만약 빙산이 하나라면 첫번째 DFS 탐색을 하면 모두 방문처리됨
			// 즉, 두번째 DFS 탐색을 시도한다면 빙산이 두 개 이상이므로 종료하면 된다.
			boolean isIceberg = false;			// 빙산을 만났는지 표시할 boolean 변수
			visited = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					// 방문하지 않은 빙산일때
					if(map[i][j] != 0 && !visited[i][j]) {
						// 두번째 빙산이면 년도 출력하고 종료
						if(isIceberg) {
							System.out.println(year);
							return;
						}
						
						// 빙산 탐색
						DFS(i, j);
						isIceberg = true;
					}
				}
			}
			
			year++;
		}
		
		System.out.println(0);
	}

	private static void melt() {
		int[][] next = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 빙산이 아닌 점에서
				if(map[i][j] != 0) {
					int sea = 0;
					// 4방을 돌며 바다 개수를 세주고
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(map[nr][nc] == 0) sea++;
					}
					
					// 빙산이 남아있다면 next에 표시해준 뒤 빙산 개수를 세준다
					if(map[i][j] - sea > 0) {
						next[i][j] = map[i][j] - sea;
						cnt++;
					}
				}
			}
		}
		
		// 빙산이 다 녹았으면 녹은 버전으로 교체해주기!
		map = next;
	}

	private static void DFS(int r, int c) {
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(map[nr][nc] != 0 && !visited[nr][nc]) DFS(nr, nc); 
		}
	}
}
