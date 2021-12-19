import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기1654 {

	static int N, K, max;
	static int[] lines;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		lines = new int[N];
		for(int i = 0; i < N; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			// 전선 K개는 1 이상의 자연수이므로 편의상 최소개수인 1개로 잘리는 max를 구해줌
			max = Math.max(max, lines[i]);
		}
		
		System.out.println(parameticSearch());
	}

	private static long parameticSearch() {
		long left = 1;
		long right = max;
		long result = 0;
		
		// left가 right보다 커지기 전까지 이분탐색.
		while(left <= right) {
			long mid = (left + right) / 2;
			// 이분탐색과 살짝 다른 점은, 단순히 값을 비교하는게 아니라
			// 현재 길이에서 전선을 몇개 자를 수 있는지 구하고 전선 갯수로 비교함!
			long cnt = cutLines(mid);
			if(cnt < K) right = mid - 1;
			else {
				// 전선을 K개 이상 자르는 경우 값을 갱신해줌.
				// 마지막으로 갱신된 값 = 답
				result = mid;
				left = mid + 1;
			}
		}
		
		return result;
	}

	// 모든 전선을 돌면서 현재 몇개로 자를 수 있는지 구하기
	// 전선은 int 범위보다 큰 개수로 자를 수 있기 때문에 long으로 계산해주어야 함. 
	private static long cutLines(long n) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			cnt += lines[i] / n;
		}
		return cnt;
	}

}
