import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐1966 {

	static class Node {
		int idx;					// 문서 번호
		int importance;				// 중요도
		
		public Node(int idx, int importance) {
			super();
			this.idx = idx;
			this.importance = importance;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] order = new int[N];					// 문서들의 순서를 저장할 배열
			Queue<Node> queue = new LinkedList<>();		// 큐
			int[] importances = new int[10];
			st = new StringTokenizer(br.readLine());
			// 입력하고
			for(int i = 0; i < N; i++) {
				int o = Integer.parseInt(st.nextToken());
				queue.offer(new Node(i, o));
				importances[o]++;
			}
						
			// 현재 우선순위
			int cnt = 1;
			outer:
			while(!queue.isEmpty()) {
				// 가장 높은 우선순위를 얻고
				int importance = 0;
				for(int i = 9; i >= 1; i--) {
					if(importances[i] != 0) {
						importance = i;
						break;
					}
				}
				
				// 문서가 해당 우선순위일때까지 큐를 poll, offer를 반복
				while(true) {
					Node n = queue.poll();
					if(n.importance == importance) {
						// 순서를 기록한 뒤
						order[n.idx] = cnt++;
						// 다음 우선순위로
						importances[importance]--;
						// 찾아야 하는 문서라면 아예 종료시키고
						if(n.idx == M) break outer;
						// 아니라면 반복문 종료 (다음 우선순위로)
						else break;
					}
					// 우선순위보다 작은 문서들은 offer
					else queue.offer(n);
				}
			}
			
			sb.append(order[M] + "\n");
		}
		
		System.out.println(sb);
	}

}
