import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선터뜨리기2346 {

	static class Balloon {
		int n;
		int index;
		
		public Balloon(int n, int index) {
			super();
			this.n = n;
			this.index = index;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Balloon> deque = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			deque.add(new Balloon(Integer.parseInt(st.nextToken()), i));
		}

		while(true) {
			// 덱의 맨 처음을 뽑는다 = 현재 풍선
			Balloon curr = deque.pollFirst();
			sb.append(curr.index + " ");
			if(deque.isEmpty()) break;
			
			int next = curr.n;
			// 다음 풍선이 -> 방향이면 숫자-1만큼 오른쪽으로 회전
			// -1하는 이유는 이미 첫번째칸 poll해서 1칸 회전한거랑 똑같기 때문
			if(next > 0) {
				for(int i = 0; i < next - 1; i++) {
					deque.addLast(deque.pollFirst());
				}
			}
			// 다음 풍선에 <- 방향이면 숫자만큼 왼쪽으로 회전
			else {
				for(int i = 0; i > next; i--) {
					deque.addFirst(deque.pollLast());
				}
			}
		}
		
		System.out.println(sb);
	}

}
