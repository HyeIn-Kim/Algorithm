import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스택을 직접 구현하는 문제.
// 어려울 줄 알았는데 막상 해보니까 쉬웠다. 공부 열심히 했구나!
public class 스택10828 {

	static int N;				// 명령어 개수
	static int[] stack;			// 스택
	static int index;			// 스택 사이즈
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		// N이 최대 10000개여서 스택오버플로우 안나게 크기를 그냥 10000으로 잡음.
		stack = new int[10001];
		// 초기 index는 0
		index = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			switch(input) {
				case "push": push(Integer.parseInt(st.nextToken())); break;
				case "pop": sb.append(pop() + "\n"); break;
				case "size": sb.append(size() + "\n"); break;
				case "empty": sb.append(empty() + "\n"); break;
				case "top": sb.append(top() + "\n"); break;
			}
		}
		
		System.out.println(sb.toString());
	}
	
	// push: 현재 칸에 값을 넣고 index 증가
	// (스택 사이즈가 커서 이 문제에서는 오버플로우가 안남)
	private static void push(int n) {
		stack[index++] = n;
	}
	
	// pop: 스택에서 가장 위에 있는 수를 반환
	// index가 0이면 아무것도 없을 때니까 -1
	private static int pop() {
		return (index == 0) ? -1 : stack[--index];
	}
	
	// size: 현재 index를 반환해주면 된다.
	private static int size() {
		return index;
	}
	
	// empty: index가 0이면 아무것도 없으므로 비어있고, 아니면 차있다.
	private static int empty() {
		return (index == 0) ? 1 : 0;
	}
	
	// top: 이게 조금 까다로웠는데, push하고 다음 index로 증가해버리니까
	// top할때는 stack[index]가 아니라 stack[index-1]을 해 줘야 했다!
	// 마찬가지로 index가 0이면 비어있으니까 -1 반환.
	private static int top() {
		return (index == 0) ? -1 : stack[index-1];
	}

}
