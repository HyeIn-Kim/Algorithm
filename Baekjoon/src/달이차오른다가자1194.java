import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단 거리를 구해야 하므로 BFS + 비트마스킹(열쇠 확인)으로 접근하는 문제.
// 비트마스킹은 잘 했는데, 처음엔 열쇠가 6개니까 visited 배열을 [N][M][7]로 만들었더니
// 열쇠의 종류가 달라도 같다고 표시해서 제대로 된 결과값이 나오지 않았다.
// 같은 1개여도 A 열쇠를 가지고 있는 거랑 D 열쇠를 가지고 있는 건 갈 수 있는 길이 달라진다!
// -> 열쇠 개수가 아닌, 열쇠 보유 상태만큼의 방문 배열을 만들어야 했던 것!
// -> 그래서 2^6인 64개만큼 visited 배열을 만들어 주었다.

public class 달이차오른다가자1194 {

	static class Node {
		int r;
		int c;
		int cnt;		// 시작점부터의 거리
		int key;		// 열쇠 보유 상태
		
		public Node(int r, int c, int cnt, int key) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
	}
	
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		// 입력
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		// 0인 위치에서 BFS 탐색 시작!
		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					BFS(i, j);
				}
			}
		}
		
		// 만약 BFS 탐색이 끝났는데도 결과가 0이라면, 출구를 못 찾았으니 -1 출력
		System.out.println((result == 0) ? -1 : result);
	}

	private static void BFS(int r, int c) {
		// 방문 배열, Queue를 생성하고
		// 시작점을 Queue에 삽입, 방문 체크를 해 준다
		visited = new boolean[N][M][(int) Math.pow(2, 6)];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, 0, 0));
		visited[r][c][0] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			// 출구일 때는 현재까지의 거리를 저장하고 함수 종료
			// BFS이기 때문에 처음으로 만나는 출구가 가장 짧은 거리가 된다.
			if(map[n.r][n.c] == '1') {
				result = n.cnt;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				// 범위에서 벗어나면 pass
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				// 이미 방문한 곳이어도 pass
				if(visited[nr][nc][n.key]) continue;
				// 벽이라면 pass
				if(map[nr][nc] == '#') continue;
				
				int nextCnt = n.cnt + 1;
				int nextKey = n.key;
				
				// 열쇠라면
				if('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
					int bit = map[nr][nc] - 'a';
					// 열쇠를 보유하지 않은 경우에만 열쇠 획득
					if((nextKey & (1 << bit)) == 0) {
						nextKey |= (1 << bit);
					}
				}
				
				// 문이라면
				if('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
					int bit = map[nr][nc] - 'A';
					// 열쇠를 가지고 있지 않다면 pass
					if((nextKey & (1 << bit)) == 0) continue;
				}
				
				// Queue에 다음 칸의 좌표, 현재거리+1, 열쇠 상태를 삽입하고
				// 방문 배열을 체크해준다!
				queue.offer(new Node(nr, nc, nextCnt, nextKey));
				visited[nr][nc][nextKey] = true;
			}
		}
	}

}
