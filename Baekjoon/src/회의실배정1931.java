import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 회의실배정1931 {

	static class Node implements Comparable<Node>{
		int start;
		int end;
		
		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> times = new PriorityQueue<Node>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			times.offer(new Node(start, end));
		}
		
		int start = 0;
		int end = 0;
		int cnt = 0;
		while(!times.isEmpty()) {
			Node time = times.poll();
			if(end <= time.start) {
				cnt++;
				start = time.start;
				end = time.end;
			}
		}
		
		System.out.println(cnt);
	}

}
