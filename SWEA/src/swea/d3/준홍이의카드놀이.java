package swea.d3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 준홍이의카드놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 1~N, 1~M인 카드의 합은 2부터 N+M까지!
			int[] cnt = new int[N+M+1];
			
			// cnt 배열에는 N+M이 몇번 나왔는지 셀 거임
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					cnt[i+j]++;
				}
			}
			
			// 제일 많이 나온 값을 구한다.
			int max = 0;
			for(int i = 2; i < cnt.length; i++) {
				if(cnt[i] > max) max = cnt[i];
			}
			
			// max번 나온 수들을 모두 PriorityQueue에 넣었다. (자동정렬 하려고)
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i = 2; i < cnt.length; i++) {
				if(cnt[i] == max) pq.add(i);
			}
			
			// 꺼내주면서 출력하면 오름차순 완성!
			sb.append("#" + testCase);
			for(Integer p : pq) {
				sb.append(" " + p);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
