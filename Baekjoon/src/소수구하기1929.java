import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[N+1];
		prime[1] = true;

		StringBuilder sb = new StringBuilder();
		// 에라토스테네스의 체로 소수를 구하는 와중에
		for(int i = 2; i <= N; i++) {
			if(prime[i]) continue;
			// M 이상 N 이하의 소수라면 세고 (이러려고 sqrt(N)이 아니라 N까지 넣었음)
			if(i >= M) sb.append(i + "\n");
			for(int j = i + i; j <= N; j += i) {
				prime[j] = true;
			}
		}
		
		// 출력한다!
		System.out.println(sb);
	}

}
