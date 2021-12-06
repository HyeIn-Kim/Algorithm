import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 2 x 5의 개수만큼 0이 생기겠구나~ 로 접근해서
//    1 ~ N까지 소수를 구한다 -> 1 ~ N까지 소인수분해를 해서 N!을 소인수분해한다
//    -> 2x5의 개수를 구해야하므로 2와 5 중 더 적은 수를 구해서 답을 구했었는데
// 2로 소인수분해되는 경우가 5로 소인수분해되는 경우보다 무조건 더 많으므로
// 그냥 5의 개수를 구해도 된다.

// 2. 그럼 5의 개수는 어떻게 구하는가?
// 팩토리얼을 쭉 나열해보면 소인수 중 2 x 5가 들어있을 때 0이 1개씩 증가하는데,
// 만약 25! 처럼 5의 제곱수면 0이 2개 증가하게 된다.
// 그래서 5로 계속 나눠주면서 누적합으로 몫을 더해주면 된다!
public class 팩토리얼0의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while(N >= 5) {
			cnt += N/5;
			N /= 5;
			System.out.println(cnt);
		}
		
		System.out.println(cnt);
		
		// 깡으로 소인수분해 하는 버전 (시간 차이는 얼마 안 난다)
//		boolean[] prime = new boolean[501];
//		for(int i = 2; i <= Math.sqrt(500); i++) {
//			if(prime[i]) continue;
//			for(int j = i + i; j <= 500; j+=i) {
//				prime[j] = true;
//			}
//		}
//		
//		int[] factors = new int[501];
//		for(int i = 2; i <= N; i++) {
//			int temp = i;
//			for(int j = 2; j <= N; j++) {
//				if(!prime[j]) {
//					while(temp % j == 0) {
//						temp /= j;
//						factors[j]++;
//					}
//				}
//				
//				if(temp == 1) break;
//			}
//		}
//		
//		System.out.println(Math.min(factors[2], factors[5]));
	}

}
