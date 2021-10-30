import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 올림픽8979 {

	// PQ로 문제 조건에 맞게 1위부터 꺼냈다.
	static class Node implements Comparable<Node> {
		int n;
		int gold;
		int silver;
		int bronze;
		
		public Node(int n, int gold, int silver, int bronze) {
			super();
			this.n = n;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Node o) {
			if(this.gold == o.gold) {
				if(this.silver == o.silver) {
					return o.bronze - this.bronze;
				}
				else return o.silver - this.silver;
			}
			else return o.gold - this.gold;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			pq.offer(new Node(n, gold, silver, bronze));
		}
		
		int order = 0;					// 현재까지의 등수
		int cnt = 1;					// 같은 등수가 몇명인지
		int gold = 0;					// 현재 금메달 수
		int silver = 0;					// 현재 은메달 수
		int bronze = 0;					// 현재 동메달 수
		
		// 1등부터 꺼내서
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			// 중복등수면 cnt를 더해주고
			if(n.gold == gold && n.silver == silver && n.bronze == bronze) {
				cnt++;
			}
			// 아니라면 등수를 갱신해준다.
			else {
				order += cnt;
				cnt = 1;
				
				gold = n.gold;
				silver = n.silver;
				bronze = n.bronze;
			}
			
			// K의 랭크 출력
			if(n.n == K) {
				System.out.println(order);
				return;
			}
		}
	}
}
