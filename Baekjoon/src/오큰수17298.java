import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// N이 최대 1,000,000까지이므로 O(N^2)를 하면 무조건 터진다!
// 1. 처음에 생각한 방법
// - 스택에 모든 수를 다 push하고, 뒤에서부터 하나씩 pop한다.
// - 매번 1 ~ i번째 수까지 검사해서 오큰수를 갱신해준다.

// 이러면 무조건 터질 것 같아서 스택에 push하면서 구해보기로 했다.
// 2. 스택에 push하면서 오큰수 구하기
// - 차례대로 스택에 넣으면서
// - 1 ~ i-1번째 수 중에서 나보다 작은 수의 오큰수를 나로 갱신해준다.
// - 그런데 push하면서 구하면, 오큰수는 나보다 큰 수 중에서 가장 왼쪽에 있는 수니까 다시 갱신할 필요가 없어진다.
// 그렇다면...

// 3. 최종 설계
// - 입력을 받는다.
// - 나의 오큰수를 -1로 세팅한다.
// - 스택에서 나보다 작은 숫자를 모두 pop하고, 오큰수를 나로 세팅한다.
// - 나를 스택에 넣는다.
public class 오큰수17298 {

	static class Node {
		int idx;
		int n;
		
		public Node(int idx, int n) {
			super();
			this.idx = idx;
			this.n = n;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Node> stack = new Stack<>();
		// 오큰수 배열
		int[] OCS = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			// 오큰수를 -1로 초기화 해준다.
			// 나중에 오큰수가 발견되면 그 수로 갱신될 것이고 발견 못하면 그대로 -1.
			OCS[i] = -1;
			
			// 스택에서 나보다 작은 수를 모두 pop
			while (!stack.isEmpty() && stack.peek().n < input) {
				Node n = stack.pop();
				// 오큰수를 나로 갱신
				OCS[n.idx] = input;
			}
			
			// 모든 연산이 끝나면 나를 스택에 넣어준다.
			stack.push(new Node(i, input));
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(OCS[i] + " ");
		}
		
		System.out.println(sb.toString());
	}

}
