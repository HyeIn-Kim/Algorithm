import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 입력 처리를 어떻게 할지가 더 걸린듯한 문제.
public class 후위표기식2_1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 입력, 알파벳값까지 먼저 다 받고
		String input = br.readLine();
		double[] alpha = new double[N];
		for(int i = 0; i < N; i++) {
			alpha[i] = Integer.parseInt(br.readLine());
		}
		
		// 스택에서 후위연산
		Stack<Double> stack = new Stack<>();
		int size = input.length();
		for(int i = 0; i < size; i++) {
			// 알파벳이면 스택에 넣고
			if('A' <= input.charAt(i) && input.charAt(i) <= 'Z') stack.push(alpha[input.charAt(i) - 'A']);
			
			// 연산자는 2번 팝해서 계산해줌
			else {
				double a = stack.pop();
				double b = stack.pop();
				char op = input.charAt(i);
				switch(op) {
					case '+': stack.push(b + a); break;
					case '-': stack.push(b - a); break;
					case '*': stack.push(b * a); break;
					case '/': stack.push(b / a); break;
				}
			}
		}
		
		// 소수점 2자리 출력
		System.out.printf("%.2f", stack.pop());
	}

}
