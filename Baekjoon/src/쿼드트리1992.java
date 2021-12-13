import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 색종이 만들기에서 문자열 처리만 더해진 문제.
// 배열 입력방법이랑 () 처리가 조금 까다로웠지 푸는 방법은 똑같다.
public class 쿼드트리1992 {

	static int N;
	static int[][] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				arr[i][j] = line[j] - '0';
			}
		}
		
		quadTree(0, 0, N);
		System.out.println(sb.toString());
	}

	private static void quadTree(int r, int c, int size) {
		if(size == 1) {
			if(arr[r][c] == 1) sb.append("1");
			else sb.append("0");
			return;
		}
		
		// 색상 구분.
		int color = arr[r][c];	// 모든 칸이 같은 색일 것이므로 첫번째 칸 색을 뽑아둠
		outer:
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				// 색이 다르면 종료
				if(arr[i][j] != color) {
					color = -1;
					break outer;
				}
			}
		}
		
		// 색이 다를 경우에만 괄호를 출력하고, 4방향으로 재귀
		if(color == -1) {
			sb.append("(");
			quadTree(r, c, size/2);
			quadTree(r, c+size/2, size/2);
			quadTree(r+size/2, c, size/2);
			quadTree(r+size/2, c+size/2, size/2);
			sb.append(")");
		}
		// 같다면 해당 색을 출력
		else if(color == 0) sb.append("0");
		else sb.append("1");
	}

}
