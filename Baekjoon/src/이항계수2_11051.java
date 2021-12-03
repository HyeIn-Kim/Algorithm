import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이항계수 1처럼 조합 공식으로 풀면 안 되는 문제.
// 나눗셈(/)은 나머지 연산 보존이 안 된다고 한다.
// 10 / 5 = 2와 10 % 3 / 5 % 3 = 1/2는 값이 다르기 때문.
// 따라서 이 문제는 파스칼의 삼각형 방식으로 풀어야 한다.
public class 이항계수2_11051 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] DP = new int[N+1][N+1];
		// 삼각형의 맨 꼭대기는 1
		DP[0][0] = 1;
		for(int i = 1; i <= N; i++) {
			// 맨 첫번째 수는 무조건 1
			DP[i][0] = 1;
			// 그 다음부터는 가장 가까운 윗줄 수를 더해서 10007로 나눠줌
			for(int j = 1; j <= i; j++) {
				DP[i][j] = (DP[i-1][j-1] + DP[i-1][j]) % 10007;
			}
		}

		System.out.println(DP[N][K]);
	}

}
