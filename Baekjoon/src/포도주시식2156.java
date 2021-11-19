import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 퇴사도 그렇고 이런건 맨날 틀린다!!
public class 포도주시식2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N+1];
		for(int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		int[] DP = new int[N+1];
		for(int i = 1; i <= N; i++) {
			DP[i] = DP[i-1];			// 이번 포도주를 안마셨을 때 (이전까지의 최대합)
			
			// 마시는 경우
			if(i >= 3) {
				// 연속해서 마실 수 없으므로 1칸전 + 3칸까지의 최대합 / 2칸전까지의 최대합 이랑 비교
				int temp = Math.max(DP[i-3] + input[i-1] + input[i], DP[i-2] + input[i]);
				
				// 마신 경우와 마시지 않은 경우를 비교
				DP[i] = Math.max(DP[i], temp);
			}
			// 1일 때는 자기 자신, 2일때는 1일차+2일차 (포도주는 양수이므로 이렇게만 해도 됨)
			else if(i == 1) DP[i] = input[i];
			else if(i == 2) DP[i] = DP[i-1] + input[i];
			
		}
		
		System.out.println(DP[N]);
	}

}
