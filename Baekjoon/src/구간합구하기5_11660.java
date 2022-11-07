import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5_11660 {
    static int N, M;
    static int[][] numbers;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1][N + 1];
        DP = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            DP[i][0] = DP[i - 1][N];
            for(int j = 1; j <= N; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j] = DP[i][j-1] + numbers[i][j];
            }
        }

        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++) {
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if(x1 == x2 && y1 == y2) sb.append(numbers[x1][y1]);
            else if(x2 - x1 == N-1 && y2 - y1 == N-1) sb.append(DP[x2][y2]);
            else sb.append(DP[x2][y2] - DP[x1][y1]);

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
