import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 이전 문제랑 같은데 괄호 종류가 늘어난 문제.
public class 균형잡힌세상4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			if(input.equals(".")) break;
			
			// 초기 정답을 yes로 설정하고, 조건이 안 맞으면 no로 변경
			String answer = "yes";
			Stack<Character> stack = new Stack<>();
			for(int j = 0; j < input.length(); j++) {
				// 열린 괄호는 전부 stack에 push
				if(input.charAt(j) == '(' || input.charAt(j) == '[') {
					stack.push(input.charAt(j));
				}
				// 닫힌 괄호가 나오면 stack에서 pop해서
				// 짝이 안 맞거나 종류가 다르면 답을 no로 했다.
				else if(input.charAt(j) == ')') {
					if(stack.size() == 0 || stack.pop() == '[') answer = "no";
				}
				else if(input.charAt(j) == ']') {
					if(stack.size() == 0 || stack.pop() == '(') answer = "no";
				}
			}
			
			// 그리고 모든 괄호를 다 확인했는데 stack에 아직 남아있다면
			// 괄호 짝이 안 맞으니까 이것도 no
			if(stack.size() != 0) answer = "no";
			sb.append(answer + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
