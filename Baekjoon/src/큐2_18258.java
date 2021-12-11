import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 큐를 직접 구현하는 문제
public class 큐2_18258 {

	static int[] queue;
	static int front, rear;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		queue = new int[N];
		front = rear = 0;
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			switch(input) {
			case "push": push(Integer.parseInt(st.nextToken())); break;
			case "pop": sb.append(pop() + "\n"); break;
			case "size": sb.append(size() + "\n"); break;
			case "empty": sb.append(((empty()) ? 1 : 0) + "\n"); break;
			case "front": sb.append(front() + "\n"); break;
			case "back": sb.append(back() + "\n"); break;
			}
		}
		
		System.out.println(sb.toString());
	}

	private static void push(int n) {
		queue[rear++] = n;
	}

	private static int pop() {
		if(empty()) return -1;
		else return queue[front++];
	}

	private static int size() {
		return rear - front;
	}

	private static boolean empty() {
		if(rear == front) return true;
		else return false;
	}

	private static int front() {
		if(empty()) return -1;
		else return queue[front];
	}

	private static int back() {
		if(empty()) return -1;
		else return queue[rear - 1];
	}

}
