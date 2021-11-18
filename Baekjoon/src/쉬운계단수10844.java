import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 0 --> X / 1
		// 1 --> 0 / 2
		// 2 --> 1 / 3
		// 3 --> 2 / 4
		// 4 --> 3 / 5
		// 5 --> 4 / 6
		// 6 --> 5 / 7
		// 7 --> 6 / 8
		// 8 --> 7 / 9
		// 9 --> 8 / X
		// 인 점을 감안하여 각 자릿수 X 0~9까지의 숫자 배열을 만들고, 이전 값에서 더해준다!
		int[][] DP = new int[N+1][10];
		
		for(int i = 1; i <= 9; i++) {
			DP[1][i] = 1;
		}
		
		// 1000000000으로 나눠줘야 하므로 계산하면서 모든 과정에서 나눠줌!
		for(int i = 2; i <= N; i++) {
			// 0이랑 9는 1개만 있으니 따로 계산하고
			DP[i][0] = DP[i-1][1] % 1000000000;
			
			// 2 ~ 8까지는 반복문으로 계산함
			for(int j = 1; j < 9; j++) {
				DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % 1000000000;
			}
			
			DP[i][9] = DP[i-1][8] % 1000000000;
		}
		
		// 마찬가지로 1000000000로 나눠주면서 계단수를 구해준다.
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += DP[N][i];
			sum %= 1000000000;
		}
		
		System.out.println(sum);
	}

}
