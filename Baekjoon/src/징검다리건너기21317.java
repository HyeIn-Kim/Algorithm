import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리건너기21317 {
    static int N, K;
    static int[][] energy;
    static int[][] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        energy = new int[N][2]; // 0: 작은 점프(1칸), 1: 큰 점프(2칸)
        DP = new int[N + 1][2]; // 0: K 점프를 뛰지 않았을 때, 1: K 점프를 뛰었을 때
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());
            energy[i][0] = small;
            energy[i][1] = big;
        }

        K = Integer.parseInt(br.readLine());
        final int MAX = 12345678;
        for(int i = 0; i <= N; i++) {
            DP[i][0] = MAX;
            DP[i][1] = MAX;
        }

        DP[1][0] = 0;
        if(N >= 2) DP[2][0] = energy[1][0];
        if(N >= 3) DP[3][0] = Math.min(energy[1][1], DP[2][0] + energy[2][0]);
        for(int i = 4; i <= N; i++) {
            // K점프 안뛸 때: 작은 점프, 큰 점프만 비교
            DP[i][0] = Math.min(DP[i - 1][0] + energy[i - 1][0], DP[i - 2][0] + energy[i - 2][1]);
            // K점프 뛸 때: 뛰었을때 작은점프, 뛰었을때 큰점프, 안뛰었을때 K점프
            DP[i][1] = Math.min(Math.min(DP[i - 1][1] + energy[i - 1][0], DP[i - 2][1] + energy[i - 2][1]), DP[i - 3][0] + K);
        }

        int answer = Math.min(DP[N][0], DP[N][1]);
        System.out.println(answer);
    }
}
