import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배낭 문제를 생각하면서 응용했는데,
// 찾아보니 O(n) 버전도 있다고 한다. 
public class 퇴사14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 시간과 금액은 1일 + 5일 걸림이면 편하게 5일로 계산하기 위해서 일부러 N으로 잡았다.
		int[] time = new int[N];
		int[] price = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());			
		}
		
		int[] DP = new int[N+1];
		// 모든 날의 일을
		for(int i = 0; i < N; i++) {
			// 뒤에서부터 확인하면서
			for(int j = N; j > 0; j--) {
				// j일에 일을 할 수 있다면
				if(i + time[i] <= j) {
					// j일에 기존 값과 (시작일까지의 값 + 일의 비용)을 비교하였다!!
					DP[j] = Math.max(DP[j], DP[i] + price[i]);
				}
			}
		}
		System.out.println(DP[N]);
	}

}
