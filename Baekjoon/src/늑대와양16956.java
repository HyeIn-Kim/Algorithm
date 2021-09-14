import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 진짜 완전 허무하다...
// 문제에서 울타리 배치하는 거 때문에 한참을 고민했는데
// 알고보니 BFS DFS도 아닌 간단한 4방탐색 문제.
public class 늑대와양16956 {

	static int N, M;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			map[i] = input.toCharArray();
		}
		
		int result = 1;
		outer: for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'S') {
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						// 범위 벗어나면 pass
						if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
						// 양/늑대 접촉만 검사하면 결과는 나오는 거니까
						// 울타리 안만들었었는데 적당히 빈칸에 만들어 주었다.
						// 울타리의 위치/개수는 상관 없고 "만들었냐" 가 중요한듯
						if(map[nr][nc] == '.') map[nr][nc] = 'D';
						// 양 4방에 늑대가 있다면 울타리를 세울 수 없으므로
						// result를 0으로 하고 바로 탐색을 종료했다.
						// break 안해도 시간 비슷한 거 보니 헛도는 테케는 없는듯 하다.
						if(map[nr][nc] == 'W') {
							result = 0;
							break outer;
						}
					}
				}
			}
		}
		
		sb.append(result + "\n");
		if(result == 1) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}			
		}
		System.out.println(sb);
	}

}
