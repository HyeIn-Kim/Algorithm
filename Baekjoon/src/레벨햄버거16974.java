import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 레벨햄버거16974 {

	// 햄버거의 구조를 잘 생각해보자!
	// 레벨 1: BPPPB
	// 레벨 2: BBPPPBPBPPPBB 일 때, 5개의 파트로 나눠본다.
	// B / BPPPB / P / BPPPB / B
	// 0 / 레벨-1의 총 패티 수 / 1 / 레벨-1의 총 패티 수 / 0
	// 더해보면
	// 0 / 레벨-1의 총 패티 수 / 레벨-1의 총 패티 수 + 1 / (레벨-1의 총 패티 수 + 1) + 레벨-1의 총 패티 수 / 레벨의 총 패티 수
	// 레벨-1의 총 패티 수인건 알겠는데, 정확한 패티 수를 어떻게 구할까? -> 재귀함수로 0레벨까지 파고들어가보자!
	static long[] burger;
	static long[] patty;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long X = Long.parseLong(st.nextToken());
		
		burger = new long[N+1];
		patty = new long[N+1];
		
		burger[0] = 1;
		patty[0] = 1;
		
		for(int i = 1; i <= N; i++) {
			burger[i] = (burger[i-1] * 2) + 3;
			patty[i] = (patty[i-1] * 2) + 1;
		}
		
		System.out.println(getPatty(N, X));
	}

	private static long getPatty(int n, long x) {
		// 레벨 0일때
		if(n == 0) {
			if(x == 0) return 0;
			else if(x == 1) return 1;
		}
		
		long half = (burger[n] / 2) + 1;
		// 첫칸은 언제나 햄버거 번이므로 패티는 0장
		if(x == 1) return 0;
		
		// x가 절반보다 작다면 레벨-1로 패티를 구하러 재귀 (x-1하는 이유는 맨앞에 B가 하나 더 있기 때문에)
		else if(x < half) return getPatty(n-1, x-1);
		
		// x가 절반이라면 레벨-1 패티 + 1(가운데 P)를 return
		else if(x == half) return patty[n-1] + 1;
		
		// x가 절반보다 크고 n보다 작으면 절반까지의 패티 수 + 마찬가지로 레벨-1로 패티를 구하러 재귀
		else if(x < burger[n]) return ((patty[n-1] + 1) + getPatty(n-1, x - half));
		
		// x == n일때는 현재 레벨의 모든 패티를 return
		else return patty[n];
	}
}
