import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게리맨더링2_17779 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int total;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];		// 배열 범위는 1 ~ N까지
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 5번 선거구는 전체 - (1~4선거구의 합)을 할 것이므로 미리 구해준다!
				total += map[i][j];
			}
		}
		
		result = Integer.MAX_VALUE;
		// 각 점마다 선거구를 나눠보자!
		for(int i = 1; i <= N; i++) {
			for(int j = 2; j <= N; j++) {
				gerrymandering(i, j);
			}
		}
		System.out.println(result);
	}

	private static void gerrymandering(int r, int c) {
		// 1. 경계를 나눌 d1, d2값 찾기
		for(int d1 = 1; d1 <= N; d1++) {
			for(int d2 = 1; 1 <= c - d1 && c + d2 <= N; d2++) {
				if(N < r + d1 + d2) break;
				// 2. 경계를 나눈다
				makeBorder(r, c, d1, d2);
				
				// 3. 1~5번 인구를 구한다
				cntPeople(r, c, d1, d2);
			}
		}
	}

	// 인내심을 갖고 문제에 적힌 범위를 착실하게 쓰면 된다...
	// 경계선을 찾으면 true에 체크해준다.
	private static void makeBorder(int r, int c, int d1, int d2) {
		visited = new boolean[N+1][N+1];
		
		// 경계선 1
		int i = 0, j = 0;
		while(i <= d1 && j >= -d1) {
			visited[r + i][c + j] = true;
			i++;
			j--;
		}

		// 경계선 2
		i = 0; j = 0;
		while(i <= d2 && j <= d2) {
			visited[r + i][c + j] = true;
			i++;
			j++;
		}

		// 경계선 3
		i = d1; j = -d1;
		while((i <= (d1 + d2)) && (j <= -d1 + d2)) {
			visited[r + i][c + j] = true;
			i++;
			j++;
		}
		
		// 경계선 4
		i = d2; j = d2;
		while(i <= d2 + d1 && j >= d2 - d1) {
			visited[r + i][c + j] = true;
			i++;
			j--;
		}
	}

	private static void cntPeople(int r, int c, int d1, int d2) {
		int[] population = new int[6];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		// 1번 선거구
		for(int i = 1; i < r + d1; i++) {
			for(int j = 1; j <= c; j++) {
				// 경계선을 만나면 break
				if(visited[i][j]) break;
				population[1] += map[i][j];
			}
		}
		
		// 2번 선거구
		// 2번, 4번 선거구는 <- 방향으로 읽어주면
		// 경계를 만났을 때 break하면 깔끔하게 찾을 수 있다!!
		for(int i = 1; i <= r + d2; i++) {
			for(int j = N; j > c; j--) {
				if(visited[i][j]) break;
				population[2] += map[i][j];
			}
		}
		
		// 3번 선거구
		for(int i = r + d1; i <= N; i++) {
			for(int j = 1; j < c - d1 + d2; j++) {
				if(visited[i][j]) break;
				population[3] += map[i][j];
			}
		}
		
		// 4번 선거구
		for(int i = r + d2 + 1; i <= N; i++) {
			for(int j = N; j >= c - d1 + d2; j--) {
				if(visited[i][j]) break;
				population[4] += map[i][j];
			}
		}
		
		// 5번 선거구: 전체 - (1~4 선거구의  인구 합)
		population[5] = total - (population[1] + population[2] + population[3] + population[4]);
		// 인구가 가장 많은 선거구, 가장 적은 선거구를 구해주고
		for(int i = 1; i <= 5; i++) {
			max = Math.max(max, population[i]);
			min = Math.min(min, population[i]);
		}
		
		// 차이의 최소값을 구해준다.
		result = Math.min(result, max - min);
	}
}