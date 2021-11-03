import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수2581 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] numbers = new boolean[N+1];
		numbers[1] = true;
		// N이 소수인지 판별하려면 루트N까지만 확인하면 된다!
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(numbers[i]) continue;
			// 2i부터 시작해서 i씩 더하면 if문 쓰지 않아도 배수인 걸 알 수 있음
			for(int j = i + i; j <= N; j += i) {
				numbers[j] = true;
			}
		}
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i = M; i <= N; i++) {
			// M부터 N까지 소수인 숫자만 골라서 더해주고, 최소값을 판별한다.
			if(!numbers[i]) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		
		// 출력
		if(sum == 0) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
