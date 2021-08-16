package swea.d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 코딩토너먼트1큐버전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			Queue<Integer> queue = new LinkedList<Integer>();
			int boring = 0;
			
			for(int i = 0; i < (int)Math.pow(2, N); i++) {
				queue.offer(sc.nextInt());
			}
			
			while(queue.size() > 1) {
				int a = queue.poll();
				int b = queue.poll();
				boring += Math.abs(a - b);
				queue.offer((a > b) ? a : b);
			}
			sb.append("#" + testCase + " " + boring + "\n");
		}
		System.out.println(sb);
	}

}
