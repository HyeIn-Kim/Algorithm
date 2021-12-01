import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유클리드 호제법으로 간단하게 풀 수 있는 문제
public class 최소공배수1934 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int GCD = 0;
			if(a < b) GCD = EuclideanAlgorithm(a, b);
			else GCD = EuclideanAlgorithm(b, a);
			
			sb.append(GCD * (a / GCD) * (b / GCD) + "\n");
		}
		
		System.out.println(sb.toString());
	}

	private static int EuclideanAlgorithm(int a, int b) {
		int temp = 0;
		while(b != 0) {
			temp = a % b;
			a = b;
			b = temp;
		}
		
		return a;
	}
}
