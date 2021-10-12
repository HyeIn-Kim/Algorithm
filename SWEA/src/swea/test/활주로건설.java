package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 14890 경사로랑 똑같은 문제였다. 그래서인지 수월했음!
public class 활주로건설 {

	static int N, X;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			// 모든 방향을 검사한다!
			// checkVertical, checkHorizontal: 지나갈 수 있으면 true / 지나갈 수 없으면 false를 반환
			for(int i = 0; i < N; i++) {
				if(checkVertical(i)) cnt++;
				if(checkHorizontal(i)) cnt++;
			}
			sb.append("#" + testCase + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

	private static boolean checkVertical(int c) {
		// 방문 배열. 경사로를 설치하면 true가 된다.
		boolean[] visited = new boolean[N];
		
		for(int i = 0; i < N-1; i++) {
			// 현재 칸이 다음 칸보다 1 작을 때. <- 방향으로 경사로 설치
			if(map[i][c] + 1 == map[i+1][c]) {
				int height = map[i][c];
				
				// <- 방향으로 X만큼, 경사로 설치 여부 검사
				for(int j = i; j > i - X; j--) {
					// 범위를 벗어나면 X
					if(j < 0) return false;
					// 이미 경사로가 설치되어 있다면 중복설치 불가능하므로 X
					if(visited[j]) return false;
					// 높이가 달라도 X
					if(height != map[j][c]) return false;
					
					visited[j] = true;
				}
			}
			
			// 현재 칸보다 다음 칸이 1 작을 때: -> 방향으로 경사로 설치
			else if(map[i][c] == map[i+1][c] + 1) {
				int height = map[i+1][c];
				
				// i+1부터 -> 방향으로 X만큼 경사로 설치 여부 검사
				for(int j = i + 1; j <= i + X; j++) {
					// 범위를 벗어나서 X
					if(j >= N) return false;
					// 이미 경사로가 설치되어 있어서 X
					if(visited[j]) return false;
					// 높이가 달라서 X
					if(height != map[j][c]) return false;
					
					visited[j] = true;
				}
			}
			// 그 외 높이가 차이나면 1 이상 차이나는 것이므로 X (같은 경우는 if문에 안걸림. pass)
			else if(map[i][c] != map[i+1][c]) return false;
		}
		
		// 안되는 경우는 중간에 다 return 했으므로 여기까지 오면 경사로 설치 가능!
		return true;
	}

	// 가로 방향 검사. 세로랑 똑같고 검사 위치만 다르다.
	private static boolean checkHorizontal(int r) {
		boolean[] visited = new boolean[N];
		for(int i = 0; i < N-1; i++) {
			if(map[r][i] + 1 == map[r][i+1]) {
				int height = map[r][i];
				for(int j = i; j > i - X; j--) {
					if(j < 0) return false;
					if(visited[j]) return false;
					if(height != map[r][j]) return false;
					
					visited[j] = true;
				}
			}
			else if(map[r][i] == map[r][i+1] + 1) {
				int height = map[r][i+1];
				for(int j = i + 1; j <= i + X; j++) {
					if(j >= N) return false;
					if(visited[j]) return false;
					if(height != map[r][j]) return false;
					
					visited[j] = true;
				}
			}
			else if(map[r][i] != map[r][i+1]) return false;
		}
		
		return true;
	}

}
