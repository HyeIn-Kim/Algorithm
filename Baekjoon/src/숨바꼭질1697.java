import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// N에서 K까지의 최단 거리이므로 BFS로 접근하였다.
public class 숨바꼭질1697 {

	static class Node {
		int n;			// 현재 위치
		int cnt;		// 이동 횟수
		
		public Node(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}
	}
	
	static int[] dx = {-1, 1, 2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[100001];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(N, 0));
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			Node x = queue.poll();
			// 현재 위치가 K일 경우 종료!
			if(x.n == K) {
				System.out.println(x.cnt);
				return;
			}
			
			for(int d = 0; d < 3; d++) {
				// x-1, x+1, x*2로 다음 위치를 계산한다.
				int nx = (d == 2) ? x.n * dx[d] : x.n + dx[d];
				
				// 범위를 벗어나거나 방문했다면 pass
				if(nx < 0 || nx > 100000) continue;
				if(visited[nx]) continue;
				
				// 범위 안에 있고 방문하지 않은 정점들을 큐에 넣는다!
				queue.offer(new Node(nx, x.cnt + 1));
				visited[nx] = true;
			}
		}
	}

}
