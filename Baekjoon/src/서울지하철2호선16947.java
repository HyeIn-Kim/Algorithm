import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 서울지하철2호선16947 {

	static int N;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	static int[] dist;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N+1];

		for (int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		visited = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, -1);
		
		DFS(1, 1);
		BFS();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			sb.append(dist[i] + " ");
		}
		System.out.println(sb);
	}

	private static boolean DFS(int curr, int prev) {
		// 현재 정점을 방문 표시
		visited[curr] = true;
		
		// 인접한 모든 정점들에 대해
		for(Integer next : adjList[curr]) {
			// 이전 정점이면 pass
			if(next == prev) continue;
			
			// 방문한 정점이라면 사이클을 찾았다! Queue에 넣어주고 거리 초기화
			if(visited[next]) {
				dist[next] = 0;
				queue.add(next);
				return true;
			}
			
			// 만약 사이클을 찾았는데
			if(DFS(next, curr)) {
				// 이미 사이클 안에 있는 정점을 또 만난다면 사이클 밖이므로 false 처리
				if(dist[next] == 0) return false;
				
				// 아닐 경우 Queue에 넣어주고 거리 초기화
				else {
					dist[next] = 0;
					queue.add(next);
					return true;
				}
			}
		}
		return false;
	}
	
	private static void BFS() {
		// Queue가 빌 때까지
		while(!queue.isEmpty()) {
			int n = queue.poll();
			// 거리를 모르는 인접한 모든 정점들에 대해 현재 정점으로부터 거리 +1 해줌!
			for(Integer next : adjList[n]) {
				if(dist[next] != -1) continue;
				dist[next] = dist[n] + 1;
				queue.offer(next);
			}
		}
	}
}
