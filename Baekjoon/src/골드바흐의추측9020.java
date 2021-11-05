import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드바흐의추측9020 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		int max = Integer.MIN_VALUE;
		// 미리 입력을 받으면서 가장 큰값을 구함
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, numbers[i]);
		}
		
		// 에라토스테네스의 체로 소수 구하기
		boolean[] prime = new boolean[max+1];
		prime[1] = true;
		for(int i = 2; i <= Math.sqrt(max); i++) {
			if(prime[i]) continue;
			for(int j = i + i; j <= max; j += i) {
				prime[j] = true;
			}
		}
		
		// 모든 소수를 돌면서 모든 골드바흐 파티션 구하기
		int[][] partition = new int[(2*max)+1][2];
		for(int i = 2; i <= max; i++) {
			if(prime[i]) continue;
			for(int j = i; j <= max; j++) {
				if(prime[j]) continue;
				partition[i+j][0] = i;
				partition[i+j][1] = j;
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(partition[numbers[i]][0] + " " + partition[numbers[i]][1] + "\n");
		}
		System.out.println(sb);
	}

}
