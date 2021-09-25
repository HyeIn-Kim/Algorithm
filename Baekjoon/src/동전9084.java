import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전9084 {
	// 2xn 타일링과 굉장히 유사한 문제
	// 1원, 2원 동전이 있다고 해보자!
	// 5원까지라면
	// 1 2 3 4 5 (원)
	// 1 2 3 5 8 (가지)
	// 즉...! 5원이라면 5-1 = 4원의 최적해 + 5-2 = 3원의 최적해를 더하니 정답이 나온다.
	// 따라서 동전 N개만큼 반복문을 돌아서 (현재금액 - 동전금액) 위치의 최적해들을
	// 현재 칸에다 모두 더해주었다!
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[] input = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int[] DP = new int[M+1];
			DP[0] = 1;	// 0번째 칸은 계산 편의를 위해 초기화함
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(input[i] <= j)
						DP[j] += DP[j - input[i]];
				}
			}
			sb.append(DP[M] + "\n");
		}
		System.out.println(sb);			
	}

}
