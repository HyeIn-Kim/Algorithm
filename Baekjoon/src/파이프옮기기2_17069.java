import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 1은 N <= 16, 제한시간 1초라서 완전탐색 + 백트래킹으로 풀 수 있지만
// 파이프 옮기기 2는 N <= 32, 제한시간 0.5초로 DP로 풀어야 하는 문제이다.
// 현재 칸에 가로 파이프가 있다면 다음 칸에 가로, 대각선 파이프를 놓고
// 세로 파이프는 세로, 대각선 / 대각선 파이프는 가로, 세로, 대각선 파이프를 놓는 식으로
// DP를 구현하였다.
// 처음엔 DP를 2차원으로 만들었어서 3가지 경우가 배열에 다 안 담기고 중간에 덮어씌워지는 문제가 발생했다.
// 그래서 DP를 3차원으로 확장, 0 = 가로 / 1 = 세로 / 2 = 대각선인 경우를 나누어서 담았다!
public class 파이프옮기기2_17069 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 숫자 범위가 int를 초과하여 long으로 변경!
		long[][][] DP = new long[3][N + 1][N + 1];
		DP[0][1][2] = 1;	// 파이프 시작: (1,2)에 가로 파이프
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 가로, 대각선 파이프일 때 다음 칸 가로 파이프를 놓는다
				if ((DP[0][i][j] != 0 || DP[2][i][j] != 0)
						// 범위 검사 & 파이프 범위가 벽인지 검사
						&& j + 1 <= N && map[i][j + 1] != 1) {
					DP[0][i][j + 1] = DP[0][i][j] + DP[2][i][j];
				}

				// 세로, 대각선 파이프일 때 다음 칸 세로 파이프를 놓는다
				if ((DP[1][i][j] != 0 || DP[2][i][j] != 0) 
						&& i + 1 <= N && map[i + 1][j] != 1) {
					DP[1][i + 1][j] = DP[1][i][j] + DP[2][i][j];
				}

				// 가로, 세로, 대각선 파이프일 때 다음 칸 대각선 파이프를 놓는다
				if ((DP[0][i][j] != 0 || DP[1][i][j] != 0 || DP[2][i][j] != 0) 
						&& (j + 1 <= N && i + 1 <= N) 
						&& (map[i][j + 1] != 1 && map[i + 1][j] != 1 && map[i + 1][j + 1] != 1)) {
					DP[2][i + 1][j + 1] = DP[0][i][j] + DP[1][i][j] + DP[2][i][j];
				}
			}
		}

		// 출력은 가로 + 세로 + 대각선 파이프일 때를 합쳐서 !!
		System.out.println(DP[0][N][N] + DP[1][N][N] + DP[2][N][N]);
	}
}
