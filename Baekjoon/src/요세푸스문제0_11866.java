import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제0_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 1부터 N까지를 큐에 넣는다.
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt = 0;
		// 큐가 완전히 빌 때까지
		while(!queue.isEmpty()) {
			cnt++;
			// 큐에서 숫자를 하나씩 뽑고
			int n = queue.poll();
			// K번째 수가 아니면 큐에 다시 넣고
			if(cnt != K) queue.offer(n);
			// K번째 수는 출력함
			else {
				sb.append(n + ", ");
				// 카운트 초기화
				cnt = 0;
			}
		}
		
		// 맨 마지막 ", "을 지워줌 
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}

}
