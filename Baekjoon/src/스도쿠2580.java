import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스도쿠2580 {

	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int[][] map;					// 스도쿠 판
	static List<Node> blanks;			// 0의 위치
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		blanks = new ArrayList<>();
		// 1. 스도쿠 판을 입력받고 
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 빈칸(0)의 위치를 기억한다.
				if(map[i][j] == 0) blanks.add(new Node(i, j));
			}
		}
		
		sb = new StringBuilder();
		sudoku(0);
	}

	// 결과 출력용 함수
	private static void print() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	// boolean형으로 정답을 찾으면 바로 종료하게끔 구현함.
	private static boolean sudoku(int cnt) {
		// 0을 모두 다 채웠으면 출력하고 종료
		if(cnt == blanks.size()) {
			print();
			return true;
		}
		
		int r = blanks.get(cnt).r;
		int c = blanks.get(cnt).c;
		
		// 1부터 9까지
		for(int i = 1; i <= 9; i++) {
			// 넣을 수 있는 숫자라면
			if(isOK(r, c, i)) {
				// 값을 바꾸고 DFS 진행
				map[r][c] = i;
				if(sudoku(cnt + 1)) {
					return true;
				}
				
				// 돌아올땐 다시 초기화해준다.
				map[r][c] = 0;			
			}
		}
		
		return false;
	}

	// 가로, 세로, 3x3칸이 모두 참이라면 true, 아니면 false
	private static boolean isOK(int r, int c, int n) {
		if(checkRow(c, n) && checkCol(r, n) && checkSquare(r, c, n))
			return true;
		
		return false;
	}

	// 세로 검사
	private static boolean checkRow(int c, int n) {
		for(int i = 0; i < 9; i++) {
			if(map[i][c] == n) return false;
		}
		
		return true;
	}

	// 가로 검사
	private static boolean checkCol(int r, int n) {
		for(int i = 0; i < 9; i++) {
			if(map[r][i] == n) return false;
		}
		
		return true;
	}

	// 3x3 칸 검사
	private static boolean checkSquare(int r, int c, int n) {
		int sr = r / 3 * 3;
		int sc = c / 3 * 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[sr + i][sc + j] == n) return false;
			}
		}
		
		return true;
	}
}
