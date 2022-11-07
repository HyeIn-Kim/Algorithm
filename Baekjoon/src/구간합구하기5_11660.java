import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1 2   1 3
// 2 3   3 ?  => 3 + 3 - 1(중복됐으니 빼줌) + 3
// 구간합 부분도 범위의 윗부분, 왼쪽 빼주면 겹치는 부분 2번 빼니까 다시 1번 더해줌!
public class 구간합구하기5_11660 {
    static int N, M;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DP = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int number = Integer.parseInt(st.nextToken());
                DP[i][j] = DP[i-1][j] + DP[i][j-1] - DP[i-1][j-1] + number;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(DP[x2][y2] - DP[x1 - 1][y2] - DP[x2][y1 - 1] + DP[x1 - 1][y1 - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
