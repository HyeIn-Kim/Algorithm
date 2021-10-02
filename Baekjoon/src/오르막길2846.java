import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오르막길2846 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int min = input[0];
		int max = input[0];
		int result = 0;
		for(int i = 1; i < N; i++) {
			// 오르막길이라면 꾸준히 증가하므로 max 갱신
			if(max < input[i]) max = input[i];
			
			// 평지나 내리막길이라면 지금까지의 차이를 갱신하고
			// 다시 i부터 시작함!
			else {
				result = Math.max(result, max - min);
				min = input[i];
				max = input[i];
			}
		}
		
		result = Math.max(result, max - min);
		System.out.println(result);
	}

}
