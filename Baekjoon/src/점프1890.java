import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프1890 {
    static int N;
    static long[][] DP;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        DP = new long[N][N];
        DP[0][0] = 1;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 0) continue;
                if(i == N-1 && j == N-1) break;

                for(int d = 0; d < 2; d++) {
                    int nr = i + (dr[d] * value);
                    int nc = j + (dc[d] * value);
                    if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    DP[nr][nc] = DP[i][j] + DP[nr][nc];
                }
            }
        }

        System.out.println(DP[N-1][N-1]);
    }
}
