import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 조건에 맞게 차근차근 구현하면 되는 브루트포스 문제.
public class 야구17281 {

	static int N;
	static int[][] map;
	static boolean[] selected;		// 선택 배열
	static int[] players;			// 타자 순서
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][9];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		selected = new boolean[9];
		players = new int[9];
		// 1번 타자(0)는 4번 고정
		players[3] = 0;
		selected[3] = true;
		baseball(1);
		System.out.println(max);
	}

	private static void baseball(int cnt) {
		// 다 뽑았으면 경기를 플레이하고 최고점수를 갱신
		if(cnt == 9) {
			int score = play();
			max = Math.max(max, score);
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(selected[i]) continue;
			
			players[i] = cnt;
			selected[i] = true;
			baseball(cnt + 1);
			selected[i] = false;
		}
	}

	private static int play() {
		boolean[] base;			// 경기장 상태
		int score = 0;
		int idx = 0;
		
		for(int i = 0; i < N; i++) {
			base = new boolean[4];
			int out = 0;
			// 삼진아웃 전까지
			while(out < 3) {
				// 현재 타자 번호
				int player = players[idx % 9];
				// 타자가 하는 행동
				int go = map[i][player];
				
				// 아웃이면 아웃 카운트 증가
				if(go == 0) out++;
				
				// 1루
				else if(go == 1) {
					if(base[3]) { base[3] = false; score++; }
					if(base[2]) { base[2] = false; base[3] = true; }
					if(base[1]) { base[1] = false; base[2] = true; }
					base[1] = true;
				}
				
				// 2루
				else if(go == 2) {
					if(base[3]) { base[3] = false; score++; }
					if(base[2]) { base[2] = false; score++; }
					if(base[1]) { base[1] = false; base[3] = true; }
					base[2] = true;
				}
				
				// 3루
				else if(go == 3) {
					if(base[3]) { base[3] = false; score++; }
					if(base[2]) { base[2] = false; score++; }
					if(base[1]) { base[1] = false; score++; }
					base[3] = true;
				}
				
				// 홈런
				else if(go == 4) {
					if(base[3]) { base[3] = false; score++; }
					if(base[2]) { base[2] = false; score++; }
					if(base[1]) { base[1] = false; score++; }
					score++;
				}
				
				// 다음 타자로
				idx++;
			}
		}
		
		// 경기가 끝난 뒤 점수를 반환
		return score;
	}

}
