import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp[0] = Integer.parseInt(st.nextToken());
		int max = dp[0];		
		for(int i = 1; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			// 이전값 + 현재값이 나보다 크면 갱신, 아니라면 연속 끊고 다시 시작
			dp[i] = Math.max(dp[i-1] + n, n);
			max = Math.max(max, dp[i]);			
		}

		System.out.println(max);
	}

}
