import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 "최소 이동 횟수"
// 아하~! 이문제는 BFS가 더 쉽게 풀리겠구나~!
public class 나이트의이동7562 {

	static class Node {
		int r;
		int c;
		int cnt;
		
		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int I;
	static int startR, startC;
	static int endR, endC;
	static boolean[][] visited;
	// 나이트 이동 범위가 살짝 헷갈렸지 문제 자체는 크게 어렵지 않았다..!
	static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());
			
			BFS();
			
		}
		System.out.println(sb);
	}

	private static void BFS() {
		visited = new boolean[I][I];
		visited[startR][startC] = true;
		Queue<Node> queue = new LinkedList<>();
		// 시작점에서 BFS 시작
		queue.offer(new Node(startR, startC, 0));
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			// 도착지점일때는 결과를 출력하고 함수 리턴!
			if(n.r == endR && n.c == endC) {
				sb.append(n.cnt + "\n");
				return;
			}
			
			for(int d = 0; d < 8; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= I || nc >= I) continue;
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				queue.offer(new Node(nr, nc, n.cnt + 1));
			}
		}
	}

}
