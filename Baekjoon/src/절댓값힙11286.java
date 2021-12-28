import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 오늘은 PQ에 람다식을 연습했다.
// 맨날 Comparable만 써서 Comparator 쓰는데도 버벅였다..
public class 절댓값힙11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) - Math.abs(o2) != 0) return Math.abs(o1) - Math.abs(o2);
			else return o1 - o2;
		});
		for(int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			if(number == 0) sb.append(((pq.isEmpty()) ? 0 : pq.poll()) + "\n");
			else pq.offer(number);
		}
		
		System.out.println(sb);
	}

}
