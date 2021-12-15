import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이항 계수 조합 공식: nCr = n! / (n-r)! * r!
// % 1000000007을 구해야 하는데, 나눗셈은 모듈러 성질 적용이 안 된다.
// -> 나눗셈 대신 x 1/(n-r)!*r! 을 곱했다고 생각해보자! (=역원)
// 페르마의 소정리에 의해 (n-r)!*r! ^ 1000000007-2는 (n-r)!*r! 의 역원이므로
// 1000000007-2 제곱을 분할정복을 사용해서 구한 뒤, 식에 맞게 곱해주면 된다!
public class 이항계수3_11401 {

	static int N, K;
	static long mod = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long[] factorial = new long[N+1];
		factorial[0] = factorial[1] = 1;
		for(int i = 2; i <= N; i++) {
			factorial[i] = (factorial[i-1] * i) % mod;
		}
		
		System.out.println(((factorial[N] * pow(factorial[N-K], mod-2)) % mod) * pow(factorial[K], mod-2) % mod);
	}
	
	private static long pow(long a, long b) {
		if(b == 0) return 1;
		
		if(b % 2 == 1) return a * pow(a, b-1) % mod;
		else return pow(a * a % mod, b/2) % mod;
	}

}
