package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS + 백트래킹을 사용한 완전탐색!
public class 등산로조성 {

	static int N, K;
	static int[][] map;
	static int max;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static boolean[][] visited;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 입력을 받으면서 가장 높은 곳을 구하고 (등산로의 시작점)
					max = Math.max(map[i][j], max);
				}
			}
			
			result = Integer.MIN_VALUE;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 맵을 돌면서 등산로의 시작점을 찾으면 DFS 탐색으로 경우를 구한다.
					if(map[i][j] == max) {
						DFS(i, j, 1, false);
					}
				}
			}
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.println(sb);
	}

	private static void DFS(int r, int c, int cnt, boolean isUsed) {
		// 먼저 방문 체크를 해준 뒤
		visited[r][c] = true;
		
		// 상하좌우 4방 탐색을 한다.
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 범위를 벗어나거나 이미 지나온 곳이라면 pass
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(visited[nr][nc]) continue;
			
			// 다음 칸의 높이가 낮다면 그대로 탐색
			if(map[nr][nc] < map[r][c]) {
				DFS(nr, nc, cnt+1, isUsed);
			}
			// 다음 칸의 높이가 같거나 높다면,
			// 등산로를 깎을 수 있는지 살펴본다.
			// 또, 가장 효율 좋게 등산로를 다닐 수 있으려면 현재 칸 -1 만큼 깎는 게 가장 좋다!
			// (현재 높이가 9라면, 다음엔 깎아서 8로 만드는 식)
			// 그러니 다음 높이 - (현재 높이 - 1) 이 K보다 작은지(=깎을 수 있는지) 먼저 판단하고
			// 깎을 수 있으면 산을 깎아서 진행한다!
			else {
				if(!isUsed && map[nr][nc] - (map[r][c] - 1) <= K) {
					int tmp = map[nr][nc];
					// 맵을 깎은 높이로 변경하고 DFS 탐색!
					map[nr][nc] = map[r][c] - 1;
					DFS(nr, nc, cnt+1, true);
					
					// 조심해야 하는 부분은, DFS 탐색이 끝나고 나서 바꾸었던 값을 다시 되돌려 줘야 한다는 것!
					map[nr][nc] = tmp;
				}
			}
		}
		
		// 탐색이 끝나면 결과값을 갱신한다. (함수 맨 위에서 해도 됨)
		result = Math.max(cnt, result);
		// 방문 배열도 마찬가지. 탐색이 끝나면 미방문 상태로 되돌려 놓는다.
		visited[r][c] = false;
	}

}
