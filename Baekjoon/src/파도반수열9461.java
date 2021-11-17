import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// long이 나를 미치게 한다....
// 와.. 분명 제출 전에 배열도 다 출력해봤는데 int 범위 터지는지를 안봤다...!!
// 다음부터는 꼭 최대값 넣어서 int 터지는지 검사하자!!
public class 파도반수열9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] DP = new long[101];
		DP[1] = 1;
		DP[2] = 1;
		DP[3] = 1;
		DP[4] = 2;
		for(int i = 5; i <= 100; i++) {
			DP[i] = DP[i-1] + DP[i-5];
		}
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(DP[N] + "\n");
		}
		System.out.println(sb);
	}

}
