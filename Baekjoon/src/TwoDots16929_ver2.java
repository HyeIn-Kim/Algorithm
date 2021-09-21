import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Version 2 - O(NM)의 방법
// https://www.acmicpc.net/board/view/56645 의 답변을 보며 작성함
// 목적지를 특정하지 않고 한 번 지나온 정점은 다시 방문하지 않는 방법

// 간단한 증명입니다.
// A 지점을 방문했을 때 사이클이 만들어지지 않았다고 가정해봅시다.
// 그리고 어떤 지점 B 에 대해서 A를 지나가면 사이클이 만들어진다고 해봅시다.
// A 지점의 알파벳을 x라고 하면, A를 방문하고 dfs가 종료되었을 때 A와 연결된 모든 'x 인 지점들'에 대하여
// 사이클을 만들 수 없다는 의미가 됩니다.

// 만약 B가
// 1) 알파벳이 x가 아니거나 연결되지 않았다면 A를 지나갈 수 없으므로 사이클을 생성할 수 없고,
// 2) 알파벳이 x이고 A와 연결되었다면 A에서 dfs를 돌 때 사이클이 만들어지지 않는다고 했으므로 모순입니다.

// -> 사이클을 찾으면 바로 종료하고 결과를 출력하기 때문에
// 이미 방문한 점들은 사이클이 만들어지지 않는 점들이 됨 (현재 사이클 빼고!)
// -> 다시 조사할 필요가 없어짐!

// -> DFS를 돌면서 (1) 이전 칸이 아니고 (2) 이미 방문한 점을 만나면 사이클이라는 걸 알 수 있다!
public class TwoDots16929_ver2 {

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
				// 방문하지 않은 점만 DFS 탐색
				if(!visited[i][j]) {
					visited[i][j] = true;
					
					// 사이클을 찾았으면 for문을 종료하고 결과 출력으로
					if(DFS(i, j, -1, -1)) {
						result = true;
						break outer;
					}
				}
			}
		}
		
		System.out.println((result) ? "Yes" : "No");
	}

	private static boolean DFS(int r, int c, int pr, int pc) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 범위 벗어나면 pass
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			// 같은 색이 아니라면 pass
			if(map[nr][nc] != map[r][c]) continue;
			// 이전 방향이면 pass
			if(nr == pr && nc == pc) continue;
			
			// 방문한 점을 만나면 사이클이다!
			if(visited[nr][nc])	return true;
			
			visited[nr][nc] = true;
			if(DFS(nr, nc, r, c)) return true;
		}
		
		return false;
	}
}
