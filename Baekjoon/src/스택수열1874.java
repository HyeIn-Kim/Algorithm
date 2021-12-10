import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		// 1~n 차례차례 넣어야 하므로, 현재 스택에 어디까지 넣었는지 표시
		int idx = 1;		
		for(int i = 0; i < N;  i++) {
			int input = Integer.parseInt(br.readLine());
			// 입력받은 수를 pop하려면 1~input까지가 스택에 들어있어야 함
			// input까지 스택에 삽입해줌
			while(idx <= input) {
				stack.push(idx++);
				sb.append("+\n");
			}
			
			// 스택의 맨 위가 input이라면 빼주고
			if(stack.size() != 0 && stack.pop() == input) {
				sb.append("-\n");
			}
			// 아닐 경우에는 top보다 더 밑에 있음 = 스택 수열을 못 만듦이므로
			// NO를 출력하고 종료
			else {
				sb = new StringBuilder("NO");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
