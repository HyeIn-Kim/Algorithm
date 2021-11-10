import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성 기출문제를 너무 많이 푼거같은 풀이..
public class 체스판다시칠하기1018 {

	static int N, M;
	static char[][] map;
	static int[] dr = {0, -1, 0, 1};	// 4방탐색용
	static int[] dc = {-1, 0, 1, 0};	// 4방탐색용
	static int min;						// 체스판 최소값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 맵을 입력받고
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 체스판이 될 수 있는 모든 칸을 시도해보는데
		min = Integer.MAX_VALUE;
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				// 첫번째 칸이 검은색인 경우랑
				makeChess(i, j, 'B');
				// 하얀색인 경우를 둘다 해봄
				makeChess(i, j, 'W');
			}
		}
		
		System.out.println(min);
	}

	private static void makeChess(int r, int c, char first) {
		// 1. 맵 복사
		char[][] temp = new char[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				temp[i][j] = map[r + i][c + j];
			}
		}
		
		// 이미 체크한 칸을 다시 체크하지 않도록 방문배열 추가
		boolean[][] visited = new boolean[8][8];
		// 맨 첫칸을 인자로 들어온 값으로 변경
		temp[0][0] = first;
		int cnt = (temp[0][0] == map[r][c]) ? 0 : 1;
		visited[0][0] = true;
		
		// 8x8 모든 칸에
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				
				// 4방탐색으로 인접한 칸 중에서 같은 색이 있는지 검사
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					// 칸을 벗어나면 pass
					if(nr < 0 || nc < 0 || nr >= 8 || nc >= 8) continue;
					// 이미 체크한곳 pass
					if(visited[nr][nc]) continue;
					// 체크해주고
					visited[i][j] = true;

					// 같은색이면 cnt를 더해주고 체스판을 바꿔줌
					if(temp[i][j] == temp[nr][nc]) {
						cnt++;
						temp[nr][nc] = (temp[i][j] == 'B') ? 'W' : 'B';
					}
					
					// 만약 세다가 min보다 커지면 더 계산할 필요 없으니 종료
					if(cnt > min) return;
				}
			}
		}
		
		// 체스판 다 검사했으면 min 갱신
		min = Math.min(min, cnt);
	}

}
