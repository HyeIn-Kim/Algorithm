import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소인수분해11653 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 가장 작은 소수인 2부터 루트 N까지 돌면서
		for(int i = 2; i <= Math.sqrt(N); i++) {
			// N이 나눠진다면 쭉 나눠준다.
			// 참고로 +1씩 더해도 합성수인 인수는 그거보다 작은 소수의 결합이기 때문에
			// 작은 수부터 쭉 나누면 소수만 구할 수 있다.
			while(N % i == 0) {
				sb.append(i + "\n");
				N /= i;
			}
		}
		
		// 루트N까지 나눴으므로 루트N이 넘는 소인수는 계산을 못한다.
		// (N이 계산할수록 줄어드므로 루트N도 줄어들게 됨)
		// 따라서 1이 아니라면 남은 N도 함께 출력해준다.
		if(N != 1) sb.append(N);
		System.out.println(sb);
	}

}
