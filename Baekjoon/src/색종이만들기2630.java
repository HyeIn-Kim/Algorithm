import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기2630 {

	static int N;
	static int[][] arr;
	static int white, blue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}

	private static void solve(int r, int c, int size) {
		// 색종이 크기가 1이면 더 나눌 수 없고, arr[r][c]칸의 색종이가 된다.
		if(size == 1) {
			if(arr[r][c] == 0) white++;
			else blue++;
			return;
		}
		
		// 먼저 색상을 구하고
		int color = isFilled(r, c, size);
		
		// 하얀색이면 하얀색 + 1
		if(color == 0) white++;
		// 파란색이면 파란색 + 1
		else if(color == 1) blue++;
		// N/2 * N/2 사각형으로 나누어준다!
		else {
			solve(r, c, size/2);
			solve(r, c+size/2, size/2);
			solve(r+size/2, c, size/2);
			solve(r+size/2, c+size/2, size/2);
		}
	}

	private static int isFilled(int r, int c, int size) {
		int color = arr[r][c];
		int cnt = 0;
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				if(arr[i][j] == color) cnt++;
				else return -1;
			}
		}
		
		if(color == 0) return 0;
		else return 1;
	}
}
