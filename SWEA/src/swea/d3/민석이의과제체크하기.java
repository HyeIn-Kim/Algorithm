package swea.d3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 민석이의과제체크하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			// 일단 1부터 N까지 모든 수를 다 넣고
			for(int i = 1; i <= N; i++) {
				pq.add(i);
			}
			// 숙제를 낸 사람을 우선순위 큐에서 뺐다.
			for(int i = 0; i < K; i++) {
				pq.remove(sc.nextInt());
			}
			
			sb.append("#" + testCase);
			while(!pq.isEmpty()) sb.append(" " + pq.poll());
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
