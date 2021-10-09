package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벽돌깨기 {

	static int N, W, H;
	static int[][] map, copyMap;
	static int[] selected;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			copyMap = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copyMap[i][j] = map[i][j];
				}
			}

			selected = new int[N];
			result = Integer.MAX_VALUE;
			Permutation(0);
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.println(sb);
	}

	private static void Permutation(int cnt) {
		if (cnt == N) {
			// 맵 초기화
			init();
			// 총알 쏘기
			shoot();

			// 남은 벽돌의 개수를 세서
			int cntBricks = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] != 0)
						cntBricks++;
				}
			}

			// 가장 적은 값으로 갱신!
			result = Math.min(result, cntBricks);
			return;
		}

		// 총알 날릴 순서 뽑기 (중복순열)
		for (int i = 0; i < W; i++) {
			selected[cnt] = i;
			Permutation(cnt + 1);
		}
	}

	// 맵을 초기 상태로 되돌린다.
	private static void init() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}

	private static void shoot() {
		for (int c = 0; c < N; c++) {
			int r = 0;
			// 쏠 벽돌(가장 위에 있는 벽돌)을 찾는다.
			while (r < H && map[r][selected[c]] == 0) r++;

			// r가 H이라면 모든 칸이 0이라 쏠 벽돌이 없으므로
			// r가 H이 아닐 때만 벽돌을 명중시킨다.
			if (r != H) breakBricks(r, selected[c]);

			// 벽돌을 아래로 내린다.
			downBricks();
		}
	}

	private static void breakBricks(int r, int c) {
		int n = map[r][c] - 1; // 깨야 하는 벽돌 범위 (숫자-1)
		// 쏜 벽돌을 없애주자!
		map[r][c] = 0;

		for (int d = 0; d < 4; d++) {
			for (int i = 1; i <= n; i++) {
				int nr = r + (dr[d] * i);
				int nc = c + (dc[d] * i);
				// 범위 벗어나면 pass
				if (nr < 0 || nc < 0 || nr >= H || nc >= W) break;
				// 벽돌 숫자가 1이라면 해당 칸만 부숴주고
				if (map[nr][nc] == 1) map[nr][nc] = 0;
				// 1보다 크다면 연쇄적으로 벽돌을 부수러 가자!
				if (map[nr][nc] > 1) breakBricks(nr, nc);
			}
		}
	}

	private static void downBricks() {
		for (int c = 0; c < W; c++) {
			// 맵 끝에서 시작해서
			int i = H - 1;
			int j = H - 1;
			// 가장 윗줄에 도달할 때까지
			while (i >= 0 || j >= 0) {
				// 빈 칸을 찾고
				while (i >= 0 && map[i][c] != 0) i--;
				if (i < 0) break;
				
				// 숫자 칸을 찾는다
				j = i - 1;
				while (j >= 0 && map[j][c] == 0) j--;
				if (j < 0) break;

				// 0이 나올 때까지 덮어씌워준다!
				while (j >= 0 && map[j][c] != 0) {
					map[i--][c] = map[j][c];
					map[j--][c] = 0;
				}
			}
		}
	}
}
