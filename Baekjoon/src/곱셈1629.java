import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셈1629 {

	static long A, B, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(multiple(A, B));
	}

	private static long multiple(long a, long b) {
		// n^0 = 1이니까 1 리턴
		if(b == 0) return 1;
		
		// 지수가 홀수일 때는 a^5 = a * a^4 의 형태로 계산
		if(b % 2 == 1) return a * multiple(a, b-1) % C;
		// 짝수일 때는 a^4 = (a^2)^2 의 형태로 계산. 그래서 a는 제곱하고 b(횟수)는 반으로 줄어듦.
		return multiple(a * a % C, b/2) % C;
	}

}
