import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2_14442 {

	static class Node {
		int r;
		int c;
		int level;
		int k;
		
		public Node(int r, int c, int level, int k) {
			super();
			this.r = r;
			this.c = c;
			this.level = level;
			this.k = k;
		}
	}
	
	static int N, M, K;
	static int[][] map;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static boolean[][][] visited;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		// K번 벽을 부순 상태 + 아무것도 부순 상태 = K+1개의 visited 배열 필요!
		visited = new boolean[N][M][K+1];
		result = -1;
		BFS(0, 0);
		System.out.println(result);
	}
	
	private static void BFS(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, 1, 0));
		visited[r][c][0] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			if(n.r == N-1 && n.c == M-1) {
				result = n.level;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				// 범위 밖이면 pass
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				// 이미 벽을 다 부쉈다면
				if(n.k == K) {
					// 방문하지 않은 길만 갈 수 있다
					if(map[nr][nc] == 0 && !visited[nr][nc][n.k]) {
						queue.offer(new Node(nr, nc, n.level + 1, n.k));
						visited[nr][nc][n.k] = true;
					}
				}
				// 벽을 부수지 않았을 때
				else {
					// 벽을 만나면 한번 부수고 들어간다
					if(map[nr][nc] == 1 && !visited[nr][nc][n.k+1]) {
						queue.offer(new Node(nr, nc, n.level + 1, n.k+1));
						visited[nr][nc][n.k+1] = true;
					}
					
					// 방문하지 않은 길로 이동한다
					if(map[nr][nc] == 0 && !visited[nr][nc][n.k]) {
						queue.offer(new Node(nr, nc, n.level + 1, n.k));
						visited[nr][nc][n.k] = true;
					}
				}
			}
		}
	}
}
