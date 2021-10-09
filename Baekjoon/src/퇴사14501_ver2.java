import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// O(n) 버전이다.
// 이중 반복문 대신에 (1) i번째 날에 일을 할 경우 / (2) i번째 날에 일을 안 할 경우로 나눠서
// 반복문 하나로도 답을 구할 수 있었다.
public class 퇴사14501_ver2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		int[] price = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}

		int[] DP = new int[N + 1];
		for (int i = 0; i < N; i++) {
			// 일 끝나는 날이 퇴사일 전이라면
			if (i + time[i] <= N) {
				// 끝나는 날의 수입을 원래 있던 것 / i번째 일 수입을 더한 것 중에 큰 것으로 갱신
				DP[i + time[i]] = Math.max(DP[i + time[i]], DP[i] + price[i]);
			}
			
			// i번째 날 일을 하지 않았을 경우,
			// 다음날(i+1) 수입은 오늘과 같으므로 max 비교를 해준다.
			DP[i + 1] = Math.max(DP[i + 1], DP[i]);

		}
		
		// 퇴사일의 수입을 출력하면 끝!
		System.out.println(DP[N]);
	}

}
