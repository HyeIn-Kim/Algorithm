import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 처음에는 빨리 시작하는거부터 하면 되는 거 아니야? 했는데..
// -> 빨리 시작하고 오래 끝나는게 있으면 가장 많은 회의를 못구함
// 그럼 빨리 끝나는거부터 하면 되겠다!!
// -> 같은 시간에 끝나는데 시작시간이 다른경우는 못 셈
// 그래서 같은 시간에 끝나면 시작시간이 더 빠른거부터 뽑도록 PQ를 만들었음!
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
			if(this.end == o.end) {
				return this.start - o.start;
			}
			else return this.end - o.end;
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
			if(time.start >= end) {
				cnt++;
				start = time.start;
				end = time.end;
			}
		}
		
		System.out.println(cnt);
	}

}
