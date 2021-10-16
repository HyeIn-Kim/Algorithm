import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1_16926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// R번의 회전만큼
		for(int r = 0; r < R; r++) {
			// 시작 / 열(R) 끝위치 / 행(C) 끝위치
			int start = 0, endR = N, endC = M;
			
			// 바깥 사각형부터 반복 돌면서 가장 안쪽까지 채운다!
			while(start < endR && start < endC) {
				// 첫 칸을 저장해놓고
				int temp = map[start][start];
				
				// 1  2  3  4
				// 5  6  7  8
				// 9  10 11 12
				// 13 14 15 16   라면
				// 2 3 4 를 <- 으로 당겨줌
				for(int i = start; i < endC - 1; i++) {
					map[start][i] = map[start][i+1];
				}
			
				// 4 8 12 를 위로 당겨줌
				for(int i = start + 1; i < endR; i++) {
					map[i-1][endC-1] = map[i][endC-1];
				}
				
				// 13 14 15 를 -> 으로 당겨줌
				for(int i = endC - 1; i > start; i--) {
					map[endR-1][i] = map[endR-1][i-1];
				}
				
				// 5 9 를 아래로 당겨주고
				for(int i = endR - 1; i > start + 1; i--) {
					map[i][start] = map[i-1][start];
				}
				
				// 원래 1이 갔어야 하는 위치(5)에 temp에 저장했던 1을 넣어줌!
				map[start+1][start] = temp;
				
				// 시작점을 증가, 끝점을 감소시켜서 작은 사각형으로 트라이
				start++;
				endR--;
				endC--;
			}
		}
		
		// 결과 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
