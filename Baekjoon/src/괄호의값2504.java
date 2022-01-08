import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 간단할 줄 알았는데 진짜진짜! 어려웠던 문제
// 2 x (2 + (3 x 3)) 이니까 분배법칙으로 풀어서
// 2 x 2 + 2 x 9 이런식으로 풀면 됐는데...
// (, [ 을 스택에 넣을때 괄호만큼 곱해주고
// ), ] 스택에서 뺄 때는 괄호만큼 나눠주면서
// (), []가 나올 때만 정답에 더해주면서 풀었다.
// 너무 모르겠어서 답을 봤는데 어떻게 이런 생각을 했을까
public class 괄호의값2504 {

	static int size;
	static char[] brackets;
	static Stack<Character> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		brackets = br.readLine().toCharArray();
		size = brackets.length;
		stack = new Stack<>();
		
		int answer = 0;
		int temp = 1;
		for(int i = 0; i < size; i++) {
			if(brackets[i] == '(') {
				temp *= 2;
				stack.push(brackets[i]);
			}
			else if(brackets[i] == ')') {
				// 이 부분
				// 처음에는 stack.isEmpty() || (!stack.isEmpty() && stack.peek() != '(') 였는데
				// || 연산자에서 stack.isEmpty()가 참이면 뒤는 검사 안하니까 에러가 안 날테고
				// stack.isEmpty()가 거짓이면 스택이 차있는 상태에서 뒤 조건을 검사하니까
				// !stack.isEmpty()가 필요없었다. 8ms가 줄어들었다.. 연산자 주의!
				if(stack.isEmpty() || stack.peek() != '(') {
					answer = 0;
					break;
				}
				
				if(brackets[i-1] == '(' && brackets[i] == ')') answer += temp;
				temp /= 2;
				stack.pop();
			}
			else if(brackets[i] == '[') {
				temp *= 3;
				stack.push(brackets[i]);
			}
			else if(brackets[i] == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					answer = 0;
					break;
				}
				
				if(brackets[i-1] == '[' && brackets[i] == ']') answer += temp;
				temp /= 3;
				stack.pop();
			}
		}
		
		if(!stack.isEmpty()) answer = 0;
		
		System.out.println(answer);
	}

}
