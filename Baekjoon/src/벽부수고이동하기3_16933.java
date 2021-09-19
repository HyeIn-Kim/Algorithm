import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기3_16933 {

	static class Node {
		int r;
		int c;
		int level;
		int k;
		boolean day;
		
		public Node(int r, int c, int level, int k, boolean day) {
			super();
			this.r = r;
			this.c = c;
			this.level = level;
			this.k = k;
			this.day = day;
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
		BFS();
		System.out.println(result);
	}
	
	private static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0, 1, 0, true));
		visited[0][0][0] = true;
		
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
				// 이미 방문한 칸이면 pass
				if(visited[nr][nc][n.k]) continue;
				
				// 갈 수 있다면 가고 낮밤을 바꾼다
				if(map[nr][nc] == 0) {
					queue.offer(new Node(nr, nc, n.level + 1, n.k, (n.day ? false : true)));
					visited[nr][nc][n.k] = true;
				}
				
				// 벽이고 부술 수 있다면
				if(map[nr][nc] == 1 && n.k < K && !visited[nr][nc][n.k+1]) {
					// 낮에는 벽을 부수고 진행
					if(n.day) {
						queue.offer(new Node(nr, nc, n.level + 1, n.k + 1, false));
						visited[nr][nc][n.k+1] = true;						
					}
					// 밤에는 제자리에서 한번 기다림
					else {
						queue.offer(new Node(n.r, n.c, n.level + 1, n.k, true));
					}
				}
			}
		}
	}
}
