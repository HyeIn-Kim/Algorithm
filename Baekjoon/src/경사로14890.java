import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로14890 {

	static int N, L;
	static int[][] map;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
 		}

		for (int i = 0; i < N; i++) {
			checkCol(i);
			checkRow(i);
		}
		
		System.out.println(result);
	}
	
	// 가로 방향 검사
	private static void checkCol(int r) {
		boolean[] checked = new boolean[N];
		
		for(int c = 1; c < N; c++) {
			// 전 칸과 현재 칸이 같으면 pass
			if(map[r][c] == map[r][c-1]) continue;
			
			// 전 칸과 현재 칸의 높이가 1 이상 차이나면 진행 불가, return
			if(Math.abs(map[r][c] - map[r][c-1]) > 1) return;
			
			// 전 칸보다 현재 칸의 높이가 1 높을 경우: 전 칸부터 반대 방향으로 경사로를 설치한다
			if(map[r][c] - map[r][c-1] == 1) {
				for(int nc = c-1; nc >= c-L; nc--) {
					// 범위 밖을 벗어나면 경사로 설치 불가, return
					if(nc < 0) return;
					// 이미 경사로가 설치되어 있다면 경사로 설치 불가, return
					if(checked[nc]) return;
					// 높이가 변한다면 경사로 설치 불가, return
					if(map[r][nc] != map[r][c-1]) return;
					
					// 경사로 설치
					checked[nc] = true;
				}
			}
			
			// 전 칸보다 현재 칸의 높이가 1 낮을 경우: L만큼 경사로를 설치한다
			else if(map[r][c] - map[r][c-1] == -1) {
				for(int nc = c; nc < c+L; nc++) {
					// 범위 밖을 벗어나면 경사로 설치 불가, return
					if(nc >= N) return;
					// 이미 경사로가 설치되어 있다면 경사로 설치 불가, return
					if(checked[nc]) return;
					// 높이가 변한다면 경사로 설치 불가, return
					if(map[r][nc] != map[r][c]) return;
					
					checked[nc] = true;
				}
			}
		}
		result++;
	}
	
	private static void checkRow(int c) {
		boolean[] checked = new boolean[N];
		
		for(int r = 1; r < N; r++) {
			// 전 칸과 현재 칸이 같으면 pass
			if(map[r][c] == map[r-1][c]) continue;
			
			// 전 칸과 현재 칸의 높이가 1 이상 차이나면 진행 불가, return
			if(Math.abs(map[r][c] - map[r-1][c]) > 1) return;
			
			// 전 칸보다 현재 칸의 높이가 1 높을 경우: 전 칸부터 반대 방향으로 경사로를 설치한다
			if(map[r][c] - map[r-1][c] == 1) {
				for(int nr = r-1; nr >= r-L; nr--) {
					// 범위 밖을 벗어나면 경사로 설치 불가, return
					if(nr < 0) return;
					// 이미 경사로가 설치되어 있다면 경사로 설치 불가, return
					if(checked[nr]) return;
					// 높이가 변한다면 경사로 설치 불가, return
					if(map[nr][c] != map[r-1][c]) return;
					
					// 경사로 설치
					checked[nr] = true;
				}
			}
			
			// 전 칸보다 현재 칸의 높이가 1 낮을 경우: L만큼 경사로를 설치한다
			else if(map[r][c] - map[r-1][c] == -1) {
				for(int nr = r; nr < r+L; nr++) {
					// 범위 밖을 벗어나면 경사로 설치 불가, return
					if(nr >= N) return;
					// 이미 경사로가 설치되어 있다면 경사로 설치 불가, return
					if(checked[nr]) return;
					// 높이가 변한다면 경사로 설치 불가, return
					if(map[nr][c] != map[r][c]) return;
					
					checked[nr] = true;
				}
			}
		}
		result++;
	}
}
