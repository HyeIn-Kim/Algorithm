import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			// 0이 들어오면 최근 들어온 수를 지우니까 팝하고
			if(input == 0) stack.pop();
			// 아니면 푸시한다!
			else stack.push(input);
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			int n = stack.pop();
			sum += n;
		}
		
		System.out.println(sum);
	}

}
