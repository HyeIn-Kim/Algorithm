import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이 문제는 조건 맞춰서 토네이도 구현하는게 진짜 어렵고
// 구현하면 정답이라 정답률이 높은 문제였다.
// 특히 역달팽이인 토네이도 방향이 날 미치게했다..
// 1시간 고민하다가 모르겠어서 답보고 구현방법만 머리에 넣은 다음 구현은 스스로 했다.
public class 마법사상어와토네이도20057 {

	static int N;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	// 모래 이동 방향인 ds와 모래 퍼센트
	// 이것도 좌표 어떻게 쓰면 좋을지 많이 고민했다..
	static int[] ds = {-2, -1, 0, 1, 2};
	static double[][][] sandPercentage = {
			{{0, 0, 0.02, 0, 0},
			{0, 0.1, 0.07, 0.01, 0},
			{0.05, 0, 0, 0, 0},
			{0, 0.1, 0.07, 0.01, 0},
			{0, 0, 0.02, 0, 0}},
			
			{{0, 0, 0, 0, 0},
			{0, 0.01, 0, 0.01, 0},
			{0.02, 0.07, 0, 0.07, 0.02},
			{0, 0.1, 0, 0.1, 0},
			{0, 0, 0.05, 0, 0}},
			
			{{0, 0, 0.02, 0, 0},
			{0, 0.01, 0.07, 0.1, 0},
			{0, 0, 0, 0, 0.05},
			{0, 0.01, 0.07, 0.1, 0},
			{0, 0, 0.02, 0, 0}},
			
			{{0, 0, 0.05, 0, 0},
			{0, 0.1, 0, 0.1, 0},
			{0.02, 0.07, 0, 0.07, 0.02},
			{0, 0.01, 0, 0.01, 0},
			{0, 0, 0, 0, 0}}
	};
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		tornado();
		System.out.println(result);
		
	}

	private static void tornado() {
		int r = N/2;		// 현재 토네이도의 위치 r
		int c = N/2;		// 현재 토네이도의 위치 c
		int d = 0;			// 현재 토네이도의 방향: 0 왼쪽 1 아래 2 오른쪽 3 위로
		int move = 1;		// 현재 토네이도의 길이
		int cnt = 0;		// 토네이도는 같은 길이가 2번 나올때마다 1씩 늘어남. 그걸 세주기 위한 변수
		
		outer:
		while(true) {			
			cnt++;
			
			// 토네이도를 길이만큼 움직이고
			for(int i = 0; i < move; i++) {
				r += dr[d];
				c += dc[d];
				// 모래 옮기기
				moveSand(r, c, d);		
				// (0, 0) (문제에서는 (1, 1), 나머지 연산 편의를 위해 0~N-1로 잡음)이라면 끝냄
				if(r == 0 && c == 0) break outer;
			}
			
			// 같은 길이가 2번 나오면 길이를 1 늘려준다.
			if(cnt == 2) {
				cnt = 0;
				move++;
			}

			// 토네이도 방향전환
			d = (d + 1) % 4;
		}
	}

	// 여기서 (r, c)는 문제의 y칸이다.
	private static void moveSand(int r, int c, int d) {
		int sand = map[r][c];			// y의 모래를 얻어옴
		int cnt = 0;					// a칸 말고 다른칸으로 간 모래들
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				int nr = r + ds[i];
				int nc = c + ds[j];
				
				// 모래의 양을 계산한 뒤
				int s = (int) (sand * sandPercentage[d][i][j]);
				// 날아갈 곳이 맵 밖이라면 결과에 더해주고
 				if(nr < 0 || nc < 0 || nr >= N || nc >= N) result += s;
 				// 맵 안이라면 모래만큼 더해준다.
				else map[nr][nc] += s;
 				
 				// a를 구하기 위해 날아간 모래를 세 준다.
 				cnt += s;
			}
		}
		
		// a칸은 전체 모래 - 날아간 모래
		int leftSand = sand - cnt;
		// 모래가 날아갔으므로 y칸에는 모래가 0
		map[r][c] = 0;
		
		// a칸의 좌표를 구해주고
		int nr = r + dr[d];
		int nc = c + dc[d];
		// 맵 밖이라면 result에 더해주고
		if(nr < 0 || nc < 0 || nr >= N || nc >= N) result += leftSand;
		// 맵 안이라면 a칸에 더해준다!
		else map[nr][nc] += leftSand;
	}
}
