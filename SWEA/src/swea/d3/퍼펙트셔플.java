package swea.d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퍼펙트셔플 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int half = (N % 2 == 0) ? N/2 : N/2+1;
			Queue<String> a = new LinkedList<>();	// 셔플덱 A (처음~절반까지)
			Queue<String> b = new LinkedList<>();	// 셔플덱 B	(절반~끝까지)
			for(int i = 0; i < N; i++) {
				// 절반보다 작을 때는 A덱에 넣고,
				// 절반보다 클 때는 B덱에 넣는다.
				if(i < half) a.offer(sc.next());
				else b.offer(sc.next());
			}
			
			// 각각의 덱을 번갈아 가면서 출력한다.
			sb.append("#" + testCase);
			for(int i = 0; i < half; i++) {
				if(!a.isEmpty()) sb.append(" " + a.poll());
				if(!b.isEmpty()) sb.append(" " + b.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
