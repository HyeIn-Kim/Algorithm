import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대공약수: 공약수(둘의 약수) 중 가장 큰 수
// 최소공배수: 공배수(둘에 공통으로 존재하는 배수) 중 가장 작은 수
// 유클리드 호제법에서 최대공약수: a / b에서 b가 0이 될때까지 b, 나머지를 나눠줄 때의 a
// 유클리드 호제법에서 최소공배수: 위에서 구한 최대공약수 * (a / 최대공약수) * (b / 최대공약수)
public class 최대공약수와최소공배수2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int GCD = 0;
		if(a > b) GCD = EuclideanAlgorithm(a, b);
		else GCD = EuclideanAlgorithm(b, a);
		
		int LCM = GCD * (a / GCD) * (b / GCD);
		
		System.out.println(GCD);
		System.out.println(LCM);
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
