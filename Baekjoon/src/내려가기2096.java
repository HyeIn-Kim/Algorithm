import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] maxDP = new int[N][3];
		int[][] minDP = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] map = new int[3];
			for(int j = 0; j < 3; j++) {
				map[j] = Integer.parseInt(st.nextToken());
			}
			
			if(i == 0) {
				minDP[0][0] = maxDP[0][0] = map[0];
				minDP[0][1] = maxDP[0][1] = map[1];
				minDP[0][2] = maxDP[0][2] = map[2];
			}
			else {
				minDP[i][0] = Math.min(map[0] + minDP[i-1][0], map[0] + minDP[i-1][1]);
				minDP[i][1] = Math.min(map[1] + minDP[i-1][0], Math.min(map[1] + minDP[i-1][1], map[1] + minDP[i-1][2]));
				minDP[i][2] = Math.min(map[2] + minDP[i-1][1], map[2] + minDP[i-1][2]);
				
				maxDP[i][0] = Math.max(map[0] + maxDP[i-1][0], map[0] + maxDP[i-1][1]);
				maxDP[i][1] = Math.max(map[1] + maxDP[i-1][0], Math.max(map[1] + maxDP[i-1][1], map[1] + maxDP[i-1][2]));
				maxDP[i][2] = Math.max(map[2] + maxDP[i-1][1], map[2] + maxDP[i-1][2]);
			}
		}
		
		int max = Math.max(maxDP[N-1][0], Math.max(maxDP[N-1][1], maxDP[N-1][2]));
		int min = Math.min(minDP[N-1][0], Math.min(minDP[N-1][1], minDP[N-1][2]));
		System.out.println(max + " " + min);
	}

}