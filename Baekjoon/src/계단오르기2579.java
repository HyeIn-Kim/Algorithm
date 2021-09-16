import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		int[] dp = new int[N+1];
		for(int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 1; i <= N; i++) {
			if(i <= 2) {
				dp[i] = Math.max(stairs[i], stairs[i-1] + stairs[i]);
			} else {
				// 전전칸 밟기 vs 전칸+3칸 전 밟기 
				dp[i] = stairs[i] + Math.max(dp[i-2], dp[i-3] + stairs[i-1]);
			}
		}
		System.out.println(dp[N]);
	}

}
