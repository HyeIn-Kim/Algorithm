import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 또!!!!!! 점화식은 맞았는데 나머지 조건을 안본다!!!!
public class _01타일1904 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N+1];
		DP[0] = 1;
		DP[1] = 1;
		for(int i = 2; i <= N; i++) {
			// 문제 조건을 잘 읽자!
			DP[i] = ((DP[i-2] % 15746) + (DP[i-1] % 15746)) % 15746 ;
		}
		
		System.out.println(DP[N]);
	}

}
