import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 처음엔 문제를 잘못 이해해서 DFS로 접근함.
// 그런데 중간에 문제를 다시 제대로 읽으면서 DFS보다는
// BFS 접근이 더 좋을 것 같아서 BFS로 고쳐서 풀었음. 
public class 아기상어2_17086 {

	static int N, M;		// 맵의 크기 N x M
	static int[][] map;		// 입력 맵
	
	// 8방향 검사
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int maxLevel = 0;	// 상어와의 안전거리
	
	// Queue에 넣을 클래스. r, c, 지금까지의 거리
	static class Shark {
		private int r;
		private int c;
		private int level;
		
		public Shark(int r, int c, int level) {
			super();
			this.r = r;
			this.c = c;
			this.level = level;
		}
	}
	
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
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) BFS(i, j);
			}
		}
		
		System.out.println(maxLevel);
	}

	// (r, c)에서 시작해서 1(상어)를 만날 때까지 level이 커지면서 8방향을 검사하게 됨.
	private static void BFS(int r, int c) {
		// visited 배열: 처음엔 없어도 될 거라 생각했는데
		// (방문한 곳을 또 방문해도 순서가 꼬이거나 하지 않아서)
		// 없으니까 시간 초과가 났다.
		// BFS를 한번 부를 때마다 NxM 배열이 생기니까 메모리도 엄청 잡아먹던데
		// 훨씬 빠르고 좋은 풀이 방법이 있어서 다시 한번 풀어볼 예정이다.
		boolean[][] visited = new boolean[N][M];
		
		// 현재 위치를 queue에 넣고, 방문 표시를 함
		Queue<Shark> queue = new LinkedList<>();
		queue.add(new Shark(r, c, 0));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Shark s = queue.poll();
			
			// 8방향 검사
			for(int d = 0; d < 8; d++) {
				int nr = s.r + dr[d];
				int nc = s.c + dc[d];
				// 배열 범위를 벗어나거나 이미 방문했다면 continue
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				
				// 만약 상어라면 현재 거리와 max 거리를 비교하고 종료
				// level + 1인 이유는 level이 queue에 넣을때 증가하기 때문임
				// (아직 큐에 안 넣어서 레벨 증가 안했음)
				if(map[nr][nc] == 1) {
					maxLevel = Math.max(s.level + 1, maxLevel);
					return;
				}
				
				// 상어가 아니라면 방문표시, level을 1 증가시키고 queue에 넣음!
				// BFS이므로 같은 level을 다 검사하고(8방향) 다음 level로 넘어가게 됨!
				queue.add(new Shark(nr, nc, s.level + 1));
				visited[nr][nc] = true;
			}			
		}
		
	}
}
