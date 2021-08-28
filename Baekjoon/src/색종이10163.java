import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이10163 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int size = 1001;
		int[][] board = new int[size][size];
		int[] cnt = new int[N+1];
		
		for(int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			// 사각형의 범위만큼 n으로 덮어씌워주고
			for(int i = sy; i < sy+h; i++) {
				for(int j = sx; j < sx+w; j++) {
					board[i][j] = n;
				}
			}
		}
		
		// 숫자별로 넓이를 구한다.
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(board[i][j] == 0) continue;
				cnt[board[i][j]]++;
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(cnt[i] + "\n");
		}
		System.out.println(sb);
	}

}
