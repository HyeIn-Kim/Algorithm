import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내려가기2096_ver2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] maxDP = new int[2][3];
		int[][] minDP = new int[2][3];
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
				minDP[1][0] = map[0] + Math.min(minDP[0][0], minDP[0][1]);
				minDP[1][1] = map[1] + Math.min(minDP[0][0], Math.min(minDP[0][1], minDP[0][2]));
				minDP[1][2] = map[2] + Math.min(minDP[0][1], minDP[0][2]);
				minDP[0] = Arrays.copyOf(minDP[1], 3);
				
				maxDP[1][0] = map[0] + Math.max(maxDP[0][0], maxDP[0][1]);
				maxDP[1][1] = map[1] + Math.max(maxDP[0][0], Math.max(maxDP[0][1], maxDP[0][2]));
				maxDP[1][2] = map[2] + Math.max(maxDP[0][1], maxDP[0][2]);
				maxDP[0] = Arrays.copyOf(maxDP[1], 3);
			}
		}
		
		int max = Math.max(maxDP[0][0], Math.max(maxDP[0][1], maxDP[0][2]));
		int min = Math.min(minDP[0][0], Math.min(minDP[0][1], minDP[0][2]));
		System.out.println(max + " " + min);
	}

}