import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야2775 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		// 모든 층의 사람 수를 미리 구해두고 tc에 맞는 층만 출력하자!
		int[][] floor = new int[15][15];
		// 0층을 1 ~ 14로 채움
		for(int i = 1; i <= 14; i++) {
			floor[0][i] = i;
		}
		
		// 1층부터 14층까지는
		for(int i = 1; i <= 14; i++) {
			for(int j = 1; j <= 14; j++) {
				// 이전층 아래칸 + 같은층 전칸의 합을 구하면 현재 층 사람수
				floor[i][j] = floor[i-1][j] + floor[i][j-1];
			}
		}
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			sb.append(floor[k][n] + "\n");
		}
		System.out.println(sb);
	}

}
