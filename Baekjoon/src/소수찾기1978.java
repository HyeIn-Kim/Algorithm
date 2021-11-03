import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 에라토스테네스의 체
		boolean[] numbers = new boolean[1001];
		// 1은 소수가 아니니까 체크
		numbers[1] = true;
		// 2부터 1000까지
		for(int i = 2; i <= 1000; i++) {
			// 소수가 아니면 pass
			if(numbers[i]) continue;
			
			// 자기보다 큰 수 중에서 배수라면 소수가 아니니까 체크해줌
			for(int j = i + 1; j <= 1000; j++) {
				if(j % i == 0) numbers[j] = true;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		for(int n = 0; n < N; n++) {
			int input = Integer.parseInt(st.nextToken());
			// 소수 개수를 체크하고 출력한다.
			if(!numbers[input]) cnt++;
		}
		System.out.println(cnt);
	}

}
