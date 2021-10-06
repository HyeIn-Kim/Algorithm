import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파스칼의 삼각형 응용버전같은 문제였다.
public class 정수삼각형1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 먼저 N만큼의 삼각형을 입력받는다.
		int[][] input = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] DP = new int[N][N];
		DP[0][0] = input[0][0];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				// 확인해야 할 칸은 왼쪽 위와 왼쪽 위 대각선!
				// 먼저 범위가 벗어나는지 검사하고 현재 값과 윗줄+내 값 중 최대값을 DP배열에 담는다!
				if(i - 1 >= 0) {
					DP[i][j] = Math.max(DP[i][j], DP[i-1][j] + input[i][j]);
					if(j - 1 >= 0) {
						DP[i][j] = Math.max(DP[i][j], DP[i-1][j-1] + input[i][j]);
					}
				}
			}
		}
		
		// 마지막줄을 돌면서 가장 큰 값을 찾으면 끝
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, DP[N-1][i]);
		}
		
		System.out.println(max);
	}

}
