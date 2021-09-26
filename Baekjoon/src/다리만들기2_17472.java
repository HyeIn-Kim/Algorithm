import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기2_17472 {

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
	static boolean[][] visited;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int[][] adjMatrix;
	static int cntBridge;
	
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
		
		// 1. 섬들을 구분하기 위해 1부터 N까지 번호를 붙여준다.
		int cnt = 1;
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) continue;
				if(map[i][j] == 1) {
					cntIsland(i, j, cnt);
					cnt++;
				}
			}
		}
		
		// 2. 각 섬들의 주변을 탐색하고, 바다라면 해당 방향으로 전진해서
		// 다리를 놓을 수 있는지 검사한다.
		// 다리를 놓을 수 있다면 두 섬간의 가장 짧은 다리로 인접행렬을 갱신한다.
		adjMatrix = new int[cnt][cnt];
		for(int i = 0; i < cnt; i++) {
			Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
		}
		
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j]) continue;
				if(map[i][j] != 0) {
					setAdjMatrix(i, j);
				}
			}
		}
		
		// 3. Prim 알고리즘을 사용하여 최소신장트리를 찾는다.
		int result = 0;
		boolean[] visited2 = new boolean[cnt];
		int[] minEdge = new int[cnt];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		for(int i = 1; i < cnt; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int j = 1; j < cnt; j++) {
				if(!visited2[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			if(minVertex == -1) {
				System.out.println(-1);
				return;
			}
			
			visited2[minVertex] = true;
			result += min;
			
			for (int j = 1; j < cnt; j++) {
				if(!visited2[j] && adjMatrix[minVertex][j] != Integer.MAX_VALUE && (minEdge[j] > adjMatrix[minVertex][j])) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static void cntIsland(int r, int c, int cnt) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			map[n.r][n.c] = cnt;
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] != 0) {
					visited[nr][nc] = true;
					queue.offer(new Node(nr, nc));
				}
			}
		}
	}
	
	private static void setAdjMatrix(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int from = map[n.r][n.c];
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				
				// 섬 내부일때는 다른 칸으로 이동
				if(map[nr][nc] != 0) {
					visited[nr][nc] = true;
					queue.offer(new Node(nr, nc));
				}
				// 바다라면 다리를 놓을 수 있는지 보고,
				// 놓을 수 있다면 인접행렬을 갱신한다.
				if(map[nr][nc] == 0) {
					int to = getOtherIsland(nr, nc, d);
					if(to != 0) {
						adjMatrix[from][to] = Math.min(adjMatrix[from][to], cntBridge);
						adjMatrix[to][from] = Math.min(adjMatrix[to][from], cntBridge);		
					}
				}
			}
		}
	}
	
	private static int getOtherIsland(int r, int c, int d) {
		int nr = r;
		int nc = c;
		cntBridge = 1;
		int result = 0;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) break;
			if(map[nr][nc] != 0) {
				result = map[nr][nc];
				break;
			}
			cntBridge++;
		}
		
		if(cntBridge >= 2) return result;
		else return 0;
	}
}
