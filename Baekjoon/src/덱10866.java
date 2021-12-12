import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 덱을 직접 구현하는 문제.
// 큐랑 비슷할 줄 알았는데 생각할 부분이 있어서 중간에 조금 헤맸다.
public class 덱10866 {

	static int[] deque;			// 덱
	static int front, rear;		// front, rear
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		// 큐에서는 최대 N만큼 잡고, 0부터 시작했었는데
		// 덱은 front로도 넣어야 하니까 underflow를 막기 위해 2N으로 잡고
		// 인덱스를 N부터 시작했다.
		// front 범위 0 ~ N-1 (N개) / rear 범위 N ~ 2N-1 (N개)
		deque = new int[2 * N];
		front = rear = N;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			switch(input) {
			case "push_front": push_front(Integer.parseInt(st.nextToken())); break;
			case "push_back": push_back(Integer.parseInt(st.nextToken())); break;
			case "pop_front": sb.append(pop_front() + "\n"); break;
			case "pop_back": sb.append(pop_back() + "\n"); break;
			case "size": sb.append(size() + "\n"); break;
			case "empty": sb.append((empty() ? 1 : 0) + "\n"); break;
			case "front": sb.append(front() + "\n"); break;
			case "back": sb.append(back() + "\n"); break;
			}
		}
		
		System.out.println(sb.toString());
	}

	// front = rear를 초기값으로 뒀더니
	// 첫번째 push_back을 push_front가 덮어쓰는 문제가 생겼다.
	// 그래서 front는 먼저 감소시킨 뒤 넣어줌
	// back은 큐때 짰던거랑 똑같다.
	private static void push_front(int n) {
		deque[--front] = n;
	}

	private static void push_back(int n) {
		deque[rear++] = n;
	}
	
	// pop도 조금 다르다. 현재값을 return한 뒤 front 증가.
	private static int pop_front() {
		if(empty()) return -1;
		else return deque[front++];
	}
	
	private static int pop_back() {
		if(empty()) return -1;
		else return deque[--rear];
	}

	private static int size() {
		return rear - front;
	}
	
	private static boolean empty() {
		if(front == rear) return true;
		else return false;
	}
	
	// front는 증가 -> 삽입이므로 그냥 리턴해도 되지만
	// back는 삽입 -> 증가이므로 rear - 1 위치의 값을 리턴해줘야 한다.
	private static int front() {
		if(empty()) return -1;
		else return deque[front];
	}
	
	private static int back() {
		if(empty()) return -1;
		else return deque[rear - 1];
	}
}
