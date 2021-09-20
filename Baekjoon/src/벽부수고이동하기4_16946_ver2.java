import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 버전 2
// 0을 중복해서 계속 검사하기보다는,
// 0에서 BFS로 갈 수 있는 크기를 구한 다음에,
// BFS 탐색 도중 만난 벽(1)들에다가 한꺼번에 갱신하는 방법
public class 벽부수고이동하기4_16946_ver2 {

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
	static boolean[][][] visited;

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

		// 0: 빈 칸 방문 배열 / 1: 벽 방문 배열
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 && !visited[i][j][0]) BFS(i, j);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 10으로 나눠주는 것도 잊지 말기!
				sb.append((map[i][j] % 10));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void BFS(int r, int c) {
		// 탐색을 진행하다가 만난 벽들을 저장하는 Queue
		Queue<Node> walls = new LinkedList<>();
		// BFS 탐색용 Queue
		Queue<Node> queue = new LinkedList<>();
		// 지나온 0의 개수
		int size = 1;
		
		// Queue에 첫번째 Node를 삽입, 방문 체크
		queue.offer(new Node(r, c));
		visited[r][c][0] = true;
		
		// Queue가 빌 때까지(= 벽으로 막히거나 맵 끝까지) BFS 탐색
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				
				// 범위 밖으로 벗어나면 pass
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				// 0일 때는 Queue에 넣고 방문 체크, size를 1 늘린다
				if(map[nr][nc] == 0 && !visited[nr][nc][0]) {
					queue.offer(new Node(nr, nc));
					visited[nr][nc][0] = true;
					size++;
				}
				
				// 0이 아닐 때는 벽이니까 벽의 좌표를 저장하고, 벽을 방문체크
				else if(map[nr][nc] != 0 && !visited[nr][nc][1]) {
					walls.offer(new Node(nr, nc));
					visited[nr][nc][1] = true;
				}
			}
		}
		
		// BFS 탐색이 끝나면 만나온 벽들에 0의 개수만큼 더해준다.
		// 다음 탐색에서도 사용할 것이므로 갱신 후에는 방문체크를 false로 풀어줌!
		while(!walls.isEmpty()) {
			Node wall = walls.poll();
			map[wall.r][wall.c] += size;
			visited[wall.r][wall.c][1] = false;
		}
	}
}
