import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 현재 금액과 같거나 작은 동전 중 최고로 큰 동전 사용하기를 반복하면
// 필요한 동전 수의 최소값을 구할 수 있다.
public class 동전0_11047 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int index = N-1;		// 가장 금액이 큰 동전부터 시작!
		int count = 0;			// 필요한 동전의 수
		int temp = K;
		// 남은 금액이 0이 될 때까지
		while(temp > 0) {
			// 남은 금액과 같거나 작은 동전을 찾는다.
			while(coins[index] > temp) index--;
			// 개수에 몫만큼 더해주고
			count += temp / coins[index];
			// 나머지는 해당 동전을 쓰고 남은 금액이 됨
			temp %= coins[index];
		}
		
		// 출력!
		System.out.println(count);
	}

}
