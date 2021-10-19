import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어16236 {

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cnt;			// 상어와의 거리
		
		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if(this.cnt == o.cnt) {
				if(this.r == o.r) {
					return this.c - o.c;
				}
				else return this.r - o.r;
			}
			else return this.cnt - o.cnt;
		}
	}

	static int N;
	static int[][] map;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static PriorityQueue<Node> fish;
	static int size, cnt;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int sr = -1, sc = -1;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 상어를 발견하면 시작위치를 기억해두자!
				if(map[i][j] == 9) {
					sr = i;
					sc = j;
				}
			}
		}
		
		cnt = 0;		// 아기 상어가 물고기를 먹은 횟수
		size = 2;		// 아기 상어의 크기
		result = 0;		// 최종 시간
		babyShark(sr, sc);
		System.out.println(result);
	}

	private static void babyShark(int r, int c) {
		while(true) {
			getFish(r, c);					// BFS를 돌며 먹을 물고기들을 찾는다
			if(fish.size() == 0) return;	// 먹을 물고기를 찾지 못했다면 종료
			
			Node n = fish.poll();			// PQ에서 가장 가까운 물고기를 꺼내온다
			map[r][c] = 0;					// 상어 위치를 0으로
			map[n.r][n.c] = 0;				// 물고기를 먹었으니 빈칸으로
			result += n.cnt;				// 결과에 상어가 이동한 시간만큼 더해주고
			cnt++;							// 먹은 물고기 수 갱신
			if(cnt == size) {				// 만약 물고기 수가 크기와 같다면 크기를 증가시킴
				size++;
				cnt = 0;
			}
			r = n.r;						// 상어 이동!
			c = n.c;
		}
	}

	// 어차피 가장 가까운 물고기 하나만 구하면 되니까
	// BFS를 따로 Queue 만드는 게 아니라 PQ로 짰어도 됐었을 것 같다!!
	private static void getFish(int r, int c) {
		fish = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, 0));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				// 범위 밖이면 pass
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				// 이미 방문한 곳이면 pass
				if(visited[nr][nc]) continue;
				// 크기가 크면 못지나가므로 pass
				if(map[nr][nc] > size) continue;
				// 먹을 수 있는 물고기는 PQ에 삽입
				if(0 < map[nr][nc] && map[nr][nc] < size) fish.offer(new Node(nr, nc, n.cnt + 1));
				
				visited[nr][nc] = true;
				queue.offer(new Node(nr, nc, n.cnt + 1));
			}
		}
	}
}
