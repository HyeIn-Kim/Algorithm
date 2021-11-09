import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		int result = 0;
		// 1부터 M까지 모든 경우를 테스트해본다!
		// 1부터 쭉 찾아보므로 처음 발견하는 분해합이 가장 작은 분해합이 된다.
		for(int i = 0; i <= M; i++) {
			int n = i;			// 자릿수 구하기용
			int sum = i;		// 분해합
			
			// 자릿수를 sum에 모두 더해준다.
			while(n > 0) {
				sum += n % 10;
				n /= 10;
			}
			
			// 만약 분해합이 M이라면 종료
			if(sum == M) {
				result = i;
				break;
			}
		}
		
		// 출력
		System.out.println(result);
	}

}
