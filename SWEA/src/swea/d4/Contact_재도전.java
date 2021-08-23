package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연결 리스트를 만들어서 인접 리스트를 구현하던 중에
// BFS에서 꼬여서 다시 시도합니다!!
public class Contact_재도전 {

	// 인접 리스트용 Node
	static class Node {
		int data;
		Node link;

		Node(int data, Node link) {
			this.data = data;
			this.link = link;
		}
	}
	
//	// 큐에 넣을 (data, order) 쌍: BFS()에서 필요
//	static class Order {
//		int data;
//		int order;
//		
//		Order(int data, int order) {
//			this.data = data;
//			this.order = order;
//		}
//	}
	
	static Node[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			graph = new Node[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from] = new Node(to, graph[from]);
			}
			
			visited = new boolean[101];
			//System.out.println("#" + testCase + " " + BFS(start));
			System.out.println("#" + testCase + " " + BFS2(start));
		}
	}
	
//	private static int BFS(int start) {
//		visited[start] = true;
//		Queue<Order> queue = new LinkedList<>();
//		queue.offer(new Order(start, 1));
//		
//		int maxCnt = 0;		// 최대 너비(마지막으로 방문하는 노드 순서) 저장
//		int max = 0;		// 정답 저장
//		while(!queue.isEmpty()) {
//			// Queue의 제일 맨 앞 원소를 꺼내고
//			Order curr = queue.poll();
//			
//			// 너비가 더 크다면 max를 초기화
//			if(maxCnt < curr.order) {
//				maxCnt = curr.order;
//				max = curr.data;
//			} 
//			// 각 너비마다 최대값을 찾는다.
//			// 어차피 너비는 최대 너비가 될 것이므로
//			// 마지막에는 가장 마지막에 연락 받은 노드(최대 너비)의 최대값이 된다.
//			else if(maxCnt == curr.order) {
//				max = Math.max(max, curr.data);
//			}
//
//			// 인접 리스트를 돌면서 인접 노드를 순회하고
//			// 방문하지 않은 곳은 Queue에 넣음
//			for(Node node = graph[curr.data]; node != null; node = node.link) {
//				if(visited[node.data]) continue;
//
//				visited[node.data] = true;
//				queue.offer(new Order(node.data, curr.order+1));				
//			}
//
//		}
//		
//		// BFS를 함수로 따로 빼서 리턴값으로 돌려줬다.
//		// maxCnt랑 max는 static으로 빼도 되지 않을까?
//		return max;
//	}

	private static int BFS2(int start) {
		visited[start] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		int max = 0;
		while(!queue.isEmpty()) {
			// 현재 queue의 size를 계산한다.
			int size = queue.size();
			max = 0;
			
			// queue의 size만큼 원소를 꺼내고,
			// 그 원소들의 인접 노드를 다시 queue에 집어넣는다.
			// 이는 같은 너비인 원소를 모두 꺼내는 것과 같다.
			for(int i = 0; i < size; i++) {
				int num = queue.poll();
				// 같은 너비인 원소 중에서 max인 값이 들어가게 된다.
				max = Math.max(max, num);
				
				// 인접 리스트에서 인접 노드 순회
				// 방문하지 않았다면 queue에 집어넣는다.
				for(Node node = graph[num]; node != null; node = node.link) {
					if(visited[node.data]) continue;

					visited[node.data] = true;
					queue.offer(node.data);				
				}
			}
		}
		
		return max;
	}
}
