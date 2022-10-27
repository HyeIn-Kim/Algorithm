import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스티커9465 {
    static int N;
    static int[][] stickers;
    static int[][] DP;
    static int[] dr = {-1, 1};
    static int[] dc = {-1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N];
            DP = new int[2][N];
            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            DP[0][0] = stickers[0][0];
            DP[1][0] = stickers[1][0];
            for(int i = 1; i < N; i++) {
                for(int j = 0; j < 2; j++) {
                    for(int d = 0; d < 2; d++) {
                        int nr = j + dr[d];
                        int nc = i + dc[d];
                        if(nr < 0 || nc < 0 || nr >= 2 || nc >= N) continue;
                        DP[j][i] = DP[nr][nc] + stickers[j][i];
                    }
                }
            }

            System.out.println(Arrays.toString(DP[0]));
            System.out.println(Arrays.toString(DP[1]));
            sb.append(DP[0][N-1] > DP[1][N-1] ? DP[0][N-1] : DP[1][N-1]).append("\n");
        }

        System.out.println(sb);
    }
}
