import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 그리디 조건보다 구현이 더 어려웠던 문제다.
// 최소값을 구하려면 최대한 많이 빼면 되는데, 즉 덧셈 먼저 계산하고 뺄셈을 하면 된다.
// 그래서 split("-") 를 사용해서 뺄셈을 기준으로 식을 나누고,
// 안쪽 식들을 전부 더해주면서 결과를 구했다.
public class 잃어버린괄호1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// - 를 기준으로 식을 나눠줌
		String[] input = br.readLine().split("-");
		
		int result = 0;
		for(int i = 0; i < input.length; i++) {
			int sum = 0;
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < input[i].length(); j++) {
				// 숫자는 StringBuilder에 더해주고
				if('0' <= input[i].charAt(j) && input[i].charAt(j) <= '9') {
					sb.append(input[i].charAt(j));
				}
				// 연산자가 나오면 지금까지 만든 숫자를 sum에 더해준다.
				else {
					sum += Integer.parseInt(sb.toString());
					sb = new StringBuilder();
				}
			}
			
			// 식의 마지막 숫자도 빼먹지 말고 sum에 더해줌
			sum += Integer.parseInt(sb.toString());
			// i가 0이면 첫번째 수니까 첫번째 수는 빼지말고 그대로, 나머지는 결과에서 빼줌
			result = (i == 0) ? sum : result - sum;
		}

		
		System.out.println(result);
	}

}
