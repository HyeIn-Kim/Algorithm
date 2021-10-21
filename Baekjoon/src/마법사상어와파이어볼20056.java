import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사상어와파이어볼20056 {

	static class Node {
		int r;
		int c;
		int m;
		int s;
		int d;
		boolean isEven;
		
		public Node(int r, int c, int m, int s, int d, boolean isEven) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.isEven = isEven;
		}
	}
	
	static int N, M, K;
	static Queue<Node> fireballs;
	static Queue<Node> alive;
	static int[][] map;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		fireballs = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireballs.offer(new Node(r, c, m, s, d, true));
		}
		
		for(int i = 0; i < K; i++) {
			// 파이어볼 이동
			moveBalls();
			
			// 파이어볼 나누기
			divideBalls();
		}
		
		int cnt = 0;
		while(!fireballs.isEmpty()) {
			Node n = fireballs.poll();
			cnt += n.m;
		}
		System.out.println(cnt);
	}

	private static void moveBalls() {
		alive = new LinkedList<>();
		map = new int[N][N];
		while(!fireballs.isEmpty()) {
			Node n = fireballs.poll();
			int nr = (n.r + ((n.s % N) * dr[n.d]) + N) % N;
			int nc = (n.c + ((n.s % N) * dc[n.d]) + N) % N;

			if(map[nr][nc] >= 1) {
				int size = alive.size();
				for(int i = 0; i < size; i++) {
					Node a = alive.poll();
					if(a.r == nr && a.c == nc) {
						a.m += n.m;
						a.s += n.s;
						if(a.d % 2 != n.d % 2) a.isEven = false; 
					}
					alive.offer(a);
				}
			}
			else alive.offer(new Node(nr, nc, n.m, n.s, n.d, n.isEven));
			map[nr][nc]++;
		}
	}

	private static void divideBalls() {
		while(!alive.isEmpty()) {
			Node n = alive.poll();
			int cnt = map[n.r][n.c];
			if(cnt == 1) {
				fireballs.offer(n);
				continue;
			}
			
			n.m /= 5;
			n.s /= cnt;
			for(int i = (n.isEven) ? 0 : 1; i < 8; i+=2) {
				fireballs.offer(new Node(n.r, n.c, n.m, n.s, i, n.isEven));
			}
		}
	}
}
