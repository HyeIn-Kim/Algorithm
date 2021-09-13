import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 촌수계산_2644 {

	static class Node {
		int n;				// 노드 번호
		int level;			// 촌수
		
		public Node(int n, int level) {
			super();
			this.n = n;
			this.level = level;
		}
	}
	
	static int N;
	static int[][] adjMatrix;
	static int result = -1;
	static int p1;
	static int p2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		adjMatrix = new int[N+1][N+1];			// 인접 행렬 | r: 부모 c: 자식
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjMatrix[x][y] = 1;
		}
		
		visited = new boolean[N+1];
		// p1부터 시작해서 부모, 자손 BFS
		BFS(p1);
		System.out.println(result);
	}

	static boolean[] visited;
	private static void BFS(int p) {
		Queue<Node> queue = new LinkedList<>();
		// 첫 번째 값을 queue에 넣고 방문체크!
		queue.offer(new Node(p, 0));
		visited[p] = true;
		
		while(!queue.isEmpty()) {
			// 큐에서 하나 뽑고
			Node n = queue.poll();
			// p2라면 결과를 찾았으므로 return
			if(n.n == p2) {
				result = n.level;
				return;
			}
			
			// 방문하지 않은 자식들을 큐에 삽입
			for(int i = 1; i < N+1; i++) {
				if(adjMatrix[n.n][i] == 1 && !visited[i]) {
					queue.offer(new Node(i, n.level + 1));
					visited[i] = true;
				}
			}
			
			// 방문하지 않은 부모를 큐에 삽입
			for(int i = 1; i < N+1; i++) {
				if(adjMatrix[i][n.n] == 1 && !visited[i]) {
					queue.offer(new Node(i, n.level + 1));
					visited[i] = true;
				}
			}
		}
	}
}
