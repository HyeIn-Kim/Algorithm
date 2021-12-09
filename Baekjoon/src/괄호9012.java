import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이전 스택 문제들 답을 보니 직접 구현이 더 빨라서
// 이번 문제는 직접 스택을 짜서 구현해 보았다.
public class 괄호9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			char[] stack = new char[input.length()];
			int idx = 0;
			
			// 초기 정답은 YES
			String answer = "YES";
			for(int j = 0; j < input.length(); j++) {
				// 여는 괄호는 스택에 넣고
				if(input.charAt(j) == '(') stack[idx++] = '(';
				// 닫는 괄호일 때
				else {
					// 스택이 비어있다면 괄호 짝이 맞지 않으므로 NO로 변경하고
					// 그 뒤부터는 검사할 필요 없으니 break
					if(idx == 0) {
						answer = "NO";
						break;
					}
					
					// 아니라면 스택을 pop한다.
					idx--;
				}				
			}
			
			// 모든 괄호를 살펴봤는데 아직 스택에 값이 남아있다면
			// 닫는 괄호 쌍이 맞지 않으므로 답은 NO가 된다.
			if(idx != 0) answer = "NO";
			sb.append(answer + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
