import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독13458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); 
		int C = Integer.parseInt(st.nextToken()); 
		// int 범위 초과 조심!!!!
		long sum = 0;
		for(int i = 0; i < N; i++) {
			// 각 시험장에는 총감독 1명만 들어가므로 일단 총감독 1명을 넣어준다.
			A[i] -= B;
			sum++;
			
			// 그래도 사람이 남는다면 C명으로 나눈 만큼을 더해주고
			if(A[i] > 0) {
				// 나머지가 있으면 1명 더 더해주었다.
				int remainder = A[i] % C;
				sum += A[i] / C;
				if(remainder != 0) sum++;
			}
		}
		
		System.out.println(sum);
	}

}
