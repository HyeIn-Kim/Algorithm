import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 베르트랑공준4948 {

	// 아이디어
	// 1. 에라토스테네스의 체로 2n까지의 소수 구하기
	// 2. DP적인 아이디어를 사용해서 2n까지의 소수 개수 구하기
	// 3. 출력
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력이 들어올 때마다 처리하지 않고,
		// 입력이 다 끝난 뒤에 처리한다.
		ArrayList<Integer> n = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			n.add(N);
			// 입력 중에 가장 큰 수를 구하고, max * 2만큼의 소수를 구할 예정이다.
			max = Math.max(max, N);
		}
		
		// 에라토스테네스의 체로 소수 구하는 부분
		boolean[] prime = new boolean[(max * 2) + 1];
		prime[1] = true;
		for(int i = 2; i <= Math.sqrt(max * 2); i++) {
			if(prime[i]) continue;
			for(int j = i + i; j <= (max * 2); j += i) {
				prime[j] = true;
			}
		}
		
		int[] cnt = new int[(max * 2) + 1];
		// 2부터 2 * max까지 소수의 개수를 구한다.
		for(int i = 2; i <= (max * 2); i++) {
			// 소수라면 i-1의 개수에 1을 더해주고, 아니라면 그대로
			cnt[i] = cnt[i-1] + ((prime[i]) ? 0 : 1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(Integer i : n) {
			// 배열에 접근해서 구해주면 끝
			sb.append((cnt[2*i] - cnt[i]) + "\n");
		}
		System.out.println(sb);
	}

}
