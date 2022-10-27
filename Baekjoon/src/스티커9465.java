import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스티커9465 {
    static int N;
    static int[][] stickers;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N+1];
            DP = new int[2][N+1];
            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            DP[0][1] = stickers[0][1];
            DP[1][1] = stickers[1][1];

            for(int i = 2; i <= N; i++) {
                DP[0][i] = Math.max(DP[1][i - 1], DP[1][i - 2]) + stickers[0][i];
                DP[1][i] = Math.max(DP[0][i - 1], DP[0][i - 2]) + stickers[1][i];
            }

            sb.append(Math.max(DP[0][N], DP[1][N])).append("\n");
        }

        System.out.println(sb);
    }
}
