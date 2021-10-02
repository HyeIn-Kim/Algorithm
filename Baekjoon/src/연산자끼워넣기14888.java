import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 괄호 추가하기16637의 덜매운맛 버전이다. 그래서 상대적으로 쉬웠다.
// 순열을 사용하여 각 연산자 자리에 +, -, *, /을 끼워넣고,
// 모든 경우에서 최댓값/최솟값을 찾고 있다!
public class 연산자끼워넣기14888 {

	static int N;
	static int[] input, op;
	static int max, min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		op = new int[5];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		solve(1, input[1]);
		System.out.println(max);
		System.out.println(min);
	}

	private static void solve(int idx, int sum) {
		// 연산자를 모든 자리에 끼워넣었다면 최대, 최소값 비교!
		if(idx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		// 각 연산자가 남아있으면 계산해서 다음 자리로 넘긴다!
		for(int i = 1; i <= 4; i++) {
			if(op[i] == 0) continue;
			op[i]--;
			solve(idx+1, calculate(sum, input[idx+1], i));
			
			// 재귀 후 원상태로 되돌려놓기!
			op[i]++;
		}
	}
	
	// 계산용 함수
	private static int calculate(int n1, int n2, int op) {
		switch(op) {
			case 1: return n1 + n2;
			case 2: return n1 - n2;
			case 3: return n1 * n2;
			case 4: return n1 / n2;
		}
		
		return -1;
	}
}
