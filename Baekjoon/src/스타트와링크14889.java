import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크14889 {

	static int N;
	static int[][] map;
	static boolean[] selected;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = Integer.MAX_VALUE;
		selected = new boolean[N];
		Combination(0, 0);
		System.out.println(result);
	}

	//N C N/2의 조합을 구해서 최소값을 구했다!
	private static void Combination(int cnt, int start) {
		if(cnt == N/2) {
			int sumA = 0;
			int sumB = 0;
			
			// 각 팀별 점수 합산
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// i == j 이면 0점이니까 pass
					if(i == j) continue;
					
					// 선택되었으면 A팀 점수에
					if(selected[i] && selected[j]) {
						sumA += map[i][j];
					}
					// 선택되지 않았다면 B팀 점수에
					else if(!selected[i] && !selected[j]) {
						sumB += map[i][j];
					}
				}
			}
			
			// 최소값 구하기!
			result = Math.min(result, Math.abs(sumA - sumB));
			return;
		}
		
		// 조합 코드
		for(int i = start; i < N; i++) {
			selected[i] = true;
			Combination(cnt + 1, i + 1);
			selected[i] = false;
		}
	}

}
