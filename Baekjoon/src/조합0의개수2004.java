import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팩토리얼 0의 개수 응용문제.
// 조합 공식 nCr = n! / (n-r)!*r! 을 응용하였다.
// 먼저 n, n-r, r의 2, 5의 개수를 구하고
// 조합 공식에 맞춰 구한 뒤 2, 5중 더 적은 수를 답으로 했다.
// 팩토리얼에서는 5가 무조건 작았지만 조합공식에서는 연산이 들어가서 2, 5 둘중 뭐가 더 작을지 몰라서 둘 다 구해준다.
public class 조합0의개수2004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int R2 = N - R;
		
		int cnt2 = div2(N) - (div2(R) + div2(R2));
		int cnt5 = div5(N) - (div5(R) + div5(R2));
		
		System.out.println(Math.min(cnt2, cnt5));
	}

	private static int div5(int N) {
		int cnt = 0;
		while(N >= 5) {
			cnt += N/5;
			N /= 5;
		}
		
		return cnt;
	}
	
	private static int div2(int N) {
		int cnt = 0;
		while(N >= 2) {
			cnt += N/2;
			N /= 2;
		}
		
		return cnt;
	}
}
