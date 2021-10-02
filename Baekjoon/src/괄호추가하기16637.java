import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3 + 8 * 7 - 9 * 2 일 때,
// (3 + 8) * 7 로 계산하는 경우와
// 3 + (8 * 7) 로 계산하는 경우 이렇게 2가지로 탐색하면 된다.
// 비슷하게 접근했었는데 문제를 잘못 이해해서...
// (3 + 8) * 나머지인 경우랑 3 + (나머지) 라고 생각해서 많이 헤맸다. (중첩괄호처럼 생각해버림)
// 다음 숫자까지 고려해서 생각했으면 풀 수 있었을 것 같은데 아쉽다! 다음에 또 풀어봐야지
public class 괄호추가하기16637 {

	static int N;
	static int[] numbers;
	static char[] op;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		
		numbers = new int[N/2+1];
		op = new char[N/2];
		for(int i = 0; i < N; i++) {
			if(i % 2 == 0) numbers[i/2] = input[i] - '0';
			else op[i/2] = input[i];
		}

		result = Integer.MIN_VALUE;
		DFS(0, numbers[0]);
		System.out.println(result);
	}

	// 계산용 함수
	private static int calc(int n1, int n2, char op) {
		int result = -1;	
		switch(op) {
			case '+': result = n1 + n2; break;
			case '-': result = n1 - n2; break;
			case '*': result = n1 * n2; break;
		}
		
		return result;
	}
	
	private static void DFS(int idx, int sum) {
		// 모든 연산자를 다 계산했다면 최댓값을 구함
		if(idx == N/2) {
			result = Math.max(result, sum);
			return;
		}
		
		// 괄호가 없는 경우 (3 + 8)
		DFS(idx + 1, calc(sum, numbers[idx+1], op[idx]));
		
		// 괄호가 있는 경우 3 + (8 * 7)
		if(idx + 2 <= N/2) {
			DFS(idx + 2, calc(sum, calc(numbers[idx+1], numbers[idx+2], op[idx+1]), op[idx]));
		}
	}

}
