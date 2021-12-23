import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이분 탐색으로 풀 수 있는 엄청난 문제다.
// N의 범위는 10^5. 직접 N*N 배열을 만들면 10^5 * 10^5라서 당연히 메모리 초과가 나고
// 시간 제한도 걸린다.
// 그래서 B[K] => 즉 B[K]보다 작거나 같은 수는 K개 있다 로 접근해야 한다!
// 임의의 수 M을 정해서 M보다 작거나 같은 수가 K개 있으면 M이 답이 되는것.
// 그래서 M을 이분탐색으로 찾으면 된다.
public class K번째수1300 {

	static int N, K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		System.out.println(parametricSearch());
	}

	private static int parametricSearch() {
		int left = 1;
		// right 범위는 K까지!
		// 왜 K까지냐면 예) 5*5 배열에서 제일 큰 수 = 25
		// 마지막 K = 25, 즉 ==> B[K]의 최대값은 K임
		int right = K;
		int answer = 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = cntK(mid);
			if(cnt < K) left = mid + 1;
			else {
				answer = mid;
				right = mid - 1;
			}
		}
		
		return answer;
	}

	private static int cntK(int n) {
		int cnt = 0;
		for(int i = 0; i < N;  i++) {
			// 각 줄에 n보다 작거나 같은 수는
			// n / i번째줄 이거나 N개가 된다.
			cnt += Math.min(n / (i + 1), N);
		}
		return cnt;
	}

}
