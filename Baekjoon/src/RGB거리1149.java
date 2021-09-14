import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// r: 집의 개수 / c : 색깔별 별 최소 비용
		int[][] dp = new int[N+1][3];
		Arrays.fill(dp[0], 0);
		
		for(int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] RGB = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			Arrays.fill(dp[n], Integer.MAX_VALUE);
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					// 이전 색과 현재 색이 같으면 pass
					if(i == j) continue;
					// 아니라면 이전 비용과 현재 비용을 더해서 최소 비용을 갱신함
					dp[n][j] = Math.min(dp[n-1][i] + RGB[j], dp[n][j]);
				}
			}
		}
		
		// RGB 중에서 가장 적은 비용을 출력
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}

}
