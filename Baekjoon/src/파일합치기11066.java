import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파일합치기11066 {
    static int K;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            K = Integer.parseInt(br.readLine());
            sum = new int[K+1];             // i번째 장까지의 누적합. 40, 30, 30, 50이라면 40, 70, 100, 150
            dp = new int[K+1][K+1];         // dp[i][j] = i번째부터 j번째 파일을 합치는 최소값

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }

            // 이웃한 1부터 K-1장만큼 파일 합치기
            for(int k = 1; k < K; k++) {
                for(int start = 1; start + k <= K; start++) {
                    int end = start + k;
                    dp[start][end] = Integer.MAX_VALUE;

                    for(int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + (sum[end] - sum[start - 1]));
                    }
                }
            }

            sb.append(dp[1][K]).append("\n");
        }

        System.out.println(sb);
    }
}
