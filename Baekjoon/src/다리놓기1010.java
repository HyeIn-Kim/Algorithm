import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] DP = new int[31][31];
		DP[0][0] = 1;
		for(int i = 1; i <= 30; i++) {
			DP[i][0] = 1;
			for(int j = 1; j <= 30; j++) {
				DP[i][j] = DP[i-1][j-1] + DP[i-1][j];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(DP[M][N] + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
