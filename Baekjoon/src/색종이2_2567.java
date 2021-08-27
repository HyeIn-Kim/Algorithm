import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이2_2567 {

	static int[][] board;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		board = new int[101][101];	// 색종이 저장 배열
		
		// 입력
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = y; i < y + 10; i++) {
				for(int j = x; j < x + 10; j++) {
					board[i][j] = 1;
				}
			}
		}
		
		// 색종이를 붙인 칸의 사방을 살폈을 때,
		// 0이 있다면 둘레이다. 1들을 계속 검사하면서 0이 보일때마다 둘레를 증가시켰다.
		int sum = 0;
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				if(board[i][j] == 1) {
					for(int d = 0; d < 4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if(board[ni][nj] == 0) sum++;
					}
				}
			}
		}
		
		System.out.println(sum);
	}

	static int[] di = {0, -1, 0, 1};
	static int[] dj = {-1, 0, 1, 0};

}
