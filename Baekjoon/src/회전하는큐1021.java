import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// deque에 1 ~ N을 넣고,
// 다음에 찾으려는 수가 가운데보다 앞에 있으면 2번 연산을,
// 가운데보다 뒤에 있으면 3번 연산을 하는 문제.
// ArrayDeque로 선언해서 indexOf()를 쓸 수 없어가지고 좀 헤맸는데,
// LinkedList로 했으면 더 간단하게 구할 수 있었을 것 같다.
public class 회전하는큐1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[M];
		for(int i = 0; i < M; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// Deque를 만들어서 1부터 N까지 값을 넣어준다.
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			deque.offerLast(i);
		}
		
		int cnt = 0;			// 현재까지 2,3번 연산의 횟수
		int idx = 0;			// 현재까지 뽑은 숫자 개수 (0 ~ N-1까지)
		while(idx < M) {
			// 만약 덱 맨 앞 원소가 뽑고자 하는 원소가 아니라면
			// 1번 연산을 할 수 없으므로 덱을 회전한다.
			if(deque.peekFirst() != numbers[idx]) {
				// 찾고자 하는 값이 덱의 어느 위치인지 찾고
				int next = 0;
				for(Integer d : deque) {
					if(d == numbers[idx]) {
						break;
					}
					next++;
				}
				
				// 다음에 찾고자 하는 값이 중앙(전체 N - 찾은개수 idx)보다 앞에 있으면 2번 연산
				if(next <= (N-idx)/2) {
					while(deque.peekFirst() != numbers[idx]) {
						deque.offerLast(deque.pollFirst());
						cnt++;
					}
				// 3번 연산
				} else {
					while(deque.peekFirst() != numbers[idx]) {
						deque.offerFirst(deque.pollLast());
						cnt++;
					}
				}
			}
			
			// 모든 연산이 끝나 찾고자 하는 값이 deque의 맨 앞에 오므로 뽑아주고
			// idx를 증가시킨다.
			deque.pollFirst();
			idx++;
		}
		
		System.out.println(cnt);
	}

}
