package swea.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {

	static class Node {
		int r;
		int c;
		int cnt;	// 탈주 후 몇시간이 지났는지 저장할 변수. L시간 뒤면 종료.
		
		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	// 파이프별로 갈 수 있는 위치를 미리 저장해 두었다.
	static int[][] dr = { {},
			{0, -1, 0, 1}, {-1, 1}, {0, 0},
			{-1, 0}, {1, 0}, {1, 0}, {-1, 0}};
	static int[][] dc = { {}, 
			{-1, 0, 1, 0}, {0, 0}, {-1, 1},
			{0, 1}, {0, 1}, {0, -1}, {0, -1}};
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = 0;
			BFS(R, C);
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.println(sb);
	}

	// 주어진 시작 위치 R, C에서 BFS를 통해 파이프를 타고 탈주한다.
	private static void BFS(int r, int c) {
		visited = new boolean[N][M];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, 1));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int pipe = map[n.r][n.c];
			
			// L시간 전이라면 결과값에 1씩 더해주고,
			// L시간이 지나면 종료한다.
			if(n.cnt <= L) result++;
			else return;
			
			// 현재 파이프가 갈 수 있는 곳만
			for(int d = 0; d < dr[pipe].length; d++) {
				int nr = n.r + dr[pipe][d];
				int nc = n.c + dc[pipe][d];
				// 범위 밖, 이미 간 곳, 파이프가 없는 곳 pass
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 0) continue;
				
				// 다음에 올 수 있는 파이프인지 판별한다.
				int nPipe = map[nr][nc];
				// 상
				if((dr[pipe][d] == -1 && dc[pipe][d] == 0) &&
						!(nPipe == 1 || nPipe == 2 || nPipe == 5 || nPipe == 6)) continue;
				// 하
				if((dr[pipe][d] == 1 && dc[pipe][d] == 0) &&
					!(nPipe == 1 || nPipe == 2 || nPipe == 4 || nPipe == 7)) continue;
				// 좌
				if((dr[pipe][d] == 0 && dc[pipe][d] == -1) &&
						!(nPipe == 1 || nPipe == 3 || nPipe == 4 || nPipe == 5)) continue;
				// 우
				if((dr[pipe][d] == 0 && dc[pipe][d] == 1) &&
					!(nPipe == 1 || nPipe == 3 || nPipe == 6 || nPipe == 7)) continue;
				
				// 파이프가 연결되어 있다면 큐에 넣고 방문체크!
				queue.offer(new Node(nr, nc, n.cnt + 1));
				visited[nr][nc] = true;
			}
		}
	}

}
