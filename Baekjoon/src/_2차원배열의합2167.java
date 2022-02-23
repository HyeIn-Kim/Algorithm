import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2차원 누적합 문제. 이제 카카오 기출5번 풀 수 있다고~!
// 코드로 볼땐 어려웠는데 그림을 그리니까 괜찮았다!!
public class _2차원배열의합2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] input = new int[N+1][M+1];
        int[][] DP = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j] = DP[i-1][j] + DP[i][j-1] - DP[i-1][j-1] + input[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            int sum = DP[er][ec] - (DP[er][sc-1] + DP[sr-1][ec]) + DP[sr-1][sc-1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
