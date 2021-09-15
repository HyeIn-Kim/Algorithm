import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_123더하기9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i < 11; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
		}
		System.out.println(sb);
	}

}
