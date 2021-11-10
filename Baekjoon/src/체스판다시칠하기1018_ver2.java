import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 방법 2.
// 4방탐색 말고 체스판이 검정/하양 두종류밖에 없다는 점을 이용해서
// 두개랑 직접 비교해보는 방법.
public class 체스판다시칠하기1018_ver2 {

	static int N, M;
	static char[][] black = {
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
	};
	
	static char[][] white = {
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
	};
	
	static char[][] map;
	static int min;
	
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
		
		min = Integer.MAX_VALUE;
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				// 체스판이 될 수 있는 모든 칸을 시도
				makeChess(i, j);
			}
		}
		
		System.out.println(min);
	}

	private static void makeChess(int r, int c) {
		int cntBlack = 0;
		int cntWhite = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				// 검정색일 때 색을 바꿔줘야 하면 cntBlack을 증가
				if(black[i][j] != map[r + i][c + j]) cntBlack++;
				// 하얀색일 때 색을 바꿔줘야 하면 cntWhite를 증가
				if(white[i][j] != map[r + i][c + j]) cntWhite++;
				
				// 둘다 min보다 커지면 검사할 필요 없으니까 리턴
				if(cntBlack >= min && cntWhite >= min) return;
			}
		}
	
		// 체스판 다 검사했으면 min 갱신
		min = Math.min(min, Math.min(cntBlack, cntWhite));
	}

}
