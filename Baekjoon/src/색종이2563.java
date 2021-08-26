import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음 문제를 봤을 때는 수학적으로 풀려고 접근했다.
// 그런데 3장 이상 색종이가 겹칠 때부터는 막막해졌다.
// 그래서 100x100 배열을 만들고 색종이가 들어있으면 1, 없으면 0으로 중복을 거르고
// 1의 합을 더해서 넓이를 구했다.
public class 색종이2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[101][101];	// 색종이 저장 배열
		
		// 입력
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = y; i < y + 10; i++) {
				for(int j = x; j < x + 10; j++) {
					if(board[i][j] == 1) continue;
					board[i][j] = 1;
				}
			}
		}
		
		// 총 넓이 구하기
		// 1 1 1
		// 1 1 1
		// 1 1 1 이라면, 1을 모두 더하면 3x3 = 9 (넓이)가 된다!
		int sum = 0;
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				sum += board[i][j];
			}
		}
		
		System.out.println(sum);
	}

}
