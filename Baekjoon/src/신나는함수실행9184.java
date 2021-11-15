import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 조건이 재귀로 적혀있어서 구현보다 심적 부담이 더 컸던 문제..
// 재귀는 top-down이고 DP는 bottom-up이라 아직까지 좀 헷갈린다..
public class 신나는함수실행9184 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 숫자 범위가 -50부터 50부터여서 101개의 배열을 만들까 했지만
		// 그러면 인덱스랑 매칭하기 힘든데다가 어차피 음수는 무조건 0이라서 51로 했다가
		// 어차피 21부터는 다 (20, 20, 20)이니까
		// 그냥 1~20 까지만 구하면 되는거였다!
		int[][][] DP = new int[21][21][21];
		for(int i = 0; i <= 20; i++) {
			for(int j = 0; j <= 20; j++) {
				for(int k = 0; k <= 20; k++) {
					if(i == 0 || j == 0 || k == 0) DP[i][j][k] = 1;
					else if(i < j && j < k) DP[i][j][k] = DP[i][j][k-1] + DP[i][j-1][k-1] - DP[i][j-1][k];
					else DP[i][j][k] = DP[i-1][j][k] + DP[i-1][j-1][k] + DP[i-1][j][k-1] - DP[i-1][j-1][k-1];
				}
			}
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// (-1, -1, -1)을 입력받으면 종료
			if(a == -1 && b == -1 && c == -1) break;
			
			// 하나라도 음수면 1
			if(a <= 0 || b <= 0 || c <= 0) sb.append("w(" + a + ", " + b + ", " + c + ") = 1\n");
			// 하나라도 20 넘으면 (20, 20, 20)을 출력
			else if(a > 20 || b > 20 || c > 20) sb.append("w(" + a + ", " + b + ", " + c + ") = " + DP[20][20][20] + "\n");
			// 나머지는 DP로 계산한 값!
			else sb.append("w(" + a + ", " + b + ", " + c + ") = " + DP[a][b][c] + "\n");
		}
		
		System.out.println(sb);
	}

}
