import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 이 문제에서 신경써야 하는 포인트
// 1. 입력이 N, M으로 들어오는 게 아니라 M, N으로 들어옴!
// N, M 입력에 익숙해져도 문제를 잘 보고 입력받자
// 2. 토마토는 같은 속도로 익음
// -> 토마토별로 BFS를 돌리는 게 아니라
// -> 익은 토마토를 모두 Queue에 넣어서 동시에 BFS를 돌려야 함!

public class 토마토7576 {

	static class Node {
		int r;
		int c;
		int days;
		
		public Node(int r, int c, int days) {
			super();
			this.r = r;
			this.c = c;
			this.days = days;
		}	
	}
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int result;
	static Queue<Node> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		result = 0;		// 초기 결과값: 0 (토마토가 다 익었을 때로 가정)
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 모든 토마토를 Queue에 삽입 (입력받을 때 해도 될듯함)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					queue.offer(new Node(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		
		// 토마토들을 BFS로 익힌다!
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			result = Math.max(result, n.days);
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 0) {
					map[nr][nc] = 1;
					queue.offer(new Node(nr, nc, n.days + 1));
					visited[nr][nc] = true;
				}
			}
		}
		
		// BFS가 끝나고 나서 남은 토마토가 있으면 -1로 결과값 변경
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) result = -1;
			}
		}
	
		System.out.println(result);
	}
}
