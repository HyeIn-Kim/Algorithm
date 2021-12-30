import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 간단한 DFS/BFS 문제
// 영역의 개수를 구하는 문제라 DFS로 풀었음
public class 적록색약10026 {

	static int N;
	static char[][] map;
	static int[] cnt;
	static boolean[][][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				map[i][j] = input[j];
			}
		}
		
		cnt = new int[2];
		visited = new boolean[2][N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[0][i][j]) {
					DFS(i, j, 0, map[i][j]);
					cnt[0]++;
				}
				
				// 여기서 if를 else if라고 써서 틀렸다..
				if(!visited[1][i][j]) {
					DFS(i, j, 1, map[i][j]);
					cnt[1]++;
				}
			}
		}
		
		System.out.println(cnt[0] + " " + cnt[1]);
	}

	// 문제 조건대로 구현하면 되는 문제.
	// num: 0 = 적록색약 아닌사람
	// num: 1 = 적록색약인 사람
	private static void DFS(int r, int c, int num, char color) {
		visited[num][r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(visited[num][nr][nc]) continue;
			// 색약이 아닐 땐 같은 색 칸만 돌고
			if(num == 0 && color == map[nr][nc]) DFS(nr, nc, num, color);
			// 색약일 때는 R/G, B 따로따로 조건을 주어서 DFS를 돌렸다.
			if(num == 1) {
				if((color == 'R' || color == 'G') && (map[nr][nc] == 'R' || map[nr][nc] == 'G')) DFS(nr, nc, num, color);
				else if(color == 'B' && map[nr][nc] == 'B') DFS(nr, nc, num, color);
			}
		}
	}

}
