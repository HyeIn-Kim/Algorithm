import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기는 ()으로 입력이 주어진다.
// )일 때, 앞칸과 비교해서 ()이 아니면 일반 막대기이므로
// 쇠막대기일 땐 스택 크기만큼 자르고 일반 막대기는 마지막 조각이므로 +1만 더해줬다.
public class 쇠막대기10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] == '(') stack.push(input[i]);
			else {
				if(input[i-1] == '(' && input[i] == ')') {
					stack.pop();
					cnt += stack.size();
				}
				else {
					stack.pop();
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
