import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
		
		// 카드는 정확히 N개이므로 1부터 i까지 돌면서 j + (i-j)와 dp[i]의 값을 비교하자!
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
			}
		}
		
		System.out.println(dp[N]);
	}

}
