import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 만들기, 쿼드트리랑 똑같은 문제인데 9방향.
// 처음에는 9방향을 다 적었었는데 반복문을 쓰면 간편했다.
public class 종이의개수1780 {

	static int N;
	static int[][] arr;
	static int minus, zero, plus;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		countPaper(0, 0, N);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

	private static void countPaper(int r, int c, int size) {
		if(size == 1) {
			switch(arr[r][c]) {
				case -1: minus++; break;
				case 0: zero++; break;
				case 1: plus++; break;
			}
			return;
		}
		
		int num = arr[r][c];
		outer:
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				// 종이가 -1, 0, 1로만 이루어져 있지 않으면 -2로 표시하고 종료
				if(arr[i][j] != num) {
					num = -2;
					break outer;
				}
			}
		}
		
		// 종이가 다를 경우에는 9방향으로 쪼개고
		if(num == -2) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					countPaper(r + (i * size / 3), c + (j * size / 3), size / 3);
				}
			}
		}
		// 나머지는 종이 숫자에 따라서 개수를 더해줌
		else if(num == -1) minus++;
		else if(num == 0) zero++;
		else plus++;
	}

}
