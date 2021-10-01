import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* <접근 idea>
 * 1. 이분그래프는 무조건 한 경우이다! 그룹에 속해 있거나, 속해 있지 않거나.
 * -> 처음에는 이거만 보고 부분집합으로 풀었었는데, 풀고 보니 V가 2만이고 E가 20만이었다.
 * 2^20000... 문제를 잘 보고 풀이방법을 고르도록 하자!
 * 
 * 2. 정점 A에서 시작해서 인접한 정점을 나와 다른 그룹으로 배치한다.
 * -> A의 인접 정점들을 큐에 넣어서 BFS 탐색을 한다
 * -> 만약 인접 정점인데 그룹이 같다면 이분 그래프가 아니므로 false 리턴!
 * 
 * 3. 어떻게 A를 특정 그룹이라고 단정할 수 있어? 다른 그룹인 경우는 어쩌라구?
 * -> 만약 A가 1그룹이면, 이분 그래프일때 A의 인접 정점은 2그룹.
 * -> A가 2그룹이라면 이분 그래프일 때 A의 인접 정점은 1그룹.
 * -> 결국 둘이 같은 소리니까 상관 없다!
 * */
public class 이분그래프1707 {
	
	static int V, E;
	static ArrayList<Integer>[] adjList;
	static int[] vertex;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= K; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[V+1];
			for(int i = 0; i <= V; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
				adjList[to].add(from);
			}
			
			// 각 정점이 어떤 그룹인지 알려주는 vertex 배열.
			// 초기값은 -1, 그룹은 0과 1로 나누어 주었다.
			// visited 용도로도 쓰인다. (-1만 정점만 골라서 BFS 탐색!)
			vertex = new int[V+1];
			for(int i = 0; i <= V; i++) {
				vertex[i] = -1;
			}
			
			boolean result = true;
			for(int i = 1; i <= V; i++) {
				// 정점을 방문하지 않았다면 BFS 탐색
				if(vertex[i] == -1) {
					// 이분 그래프가 아니라면 반복문 종료!
					if(!BFS(i)) {
						result = false;
						break;
					}
				}
			}
			
			if(result) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
	}
	
	private static boolean BFS(int n) {		
		// 첫 정점을 큐에 넣고
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		vertex[n] = 1;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			
			// 인접 정점들을 돌면서
			for(Integer nv : adjList[v]) {
				// 나와 같은 그룹이라면 이분 그래프가 아니므로 false
				if(vertex[nv] == vertex[v]) return false;
				
				// 방문하지 않은 정점을 나와 다른 그룹으로 설정, 큐에 삽입
				if(vertex[nv] == -1) {
					vertex[nv] = 1 - vertex[v];
					queue.offer(nv);
				}
			}
		}
		
		// 반복문이 무사히 끝났다면 이분그래프이다. true
		return true;
	}

}
