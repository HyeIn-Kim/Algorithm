import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] value = new int[N+1];
		int[] weight = new int[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] DP = new int[K+1];
		int max = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = K; j > 0; j--) {
				if(weight[i] <= j) {
					DP[j] = Math.max(DP[j], DP[j-weight[i]] + value[i]);
					max = Math.max(max, DP[j]);
				}
			}
		}
		
		System.out.println(max);
	}

}
