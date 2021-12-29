import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 중간값을 PQ로 어떻게 구하지? 했는데
// 오름차순, 내림차순 PQ 2개를 합치면 되는거였다!!
// max: 오름차순 PQ
// min: 내림차순 PQ
// max에 먼저 넣고, 다음엔 min에 넣고.. 를 반복하면서
// max의 top보다 min의 top이 작아지면 서로 top을 교체한다. 
// 예시 입력이 들어오면 max: -99 1 2 5 / min: 5 7 10이 되고,
// 중간값은 max의 top인 5다!!
public class 가운데를말해요1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(max.size() == min.size()) max.offer(input);
			else min.offer(input);
			
			if((!max.isEmpty() && !min.isEmpty()) && (max.peek() > min.peek())) {
				int a = max.poll();
				int b = min.poll();
				max.offer(b);
				min.offer(a);
			}
			
			sb.append(max.peek() + "\n");
		}
		System.out.println(sb);
	}

}
