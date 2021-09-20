import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 첫번째 시도!
// 모든 벽(1)에서 BFS를 출발하여 다음 벽까지의 거리를 계산
// 답은 맞는 것 같지만... 빈 칸(0)을 계속해서 검사하여 시간 초과가 나왔다.
public class 벽부수고이동하기4_16946 {

	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) BFS(i, j);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void BFS(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		queue.offer(new Node(r, c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 0) {
					map[r][c]++;
					queue.offer(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}
}
