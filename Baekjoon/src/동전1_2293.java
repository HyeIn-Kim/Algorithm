import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// O(N^2) 접근은 좋았는데,
// 1원 ~ K원까지 보려고 했다가 점화식 세우는게 너무 힘들어서 답 봤더니
// 동전 개수만큼 j원 ~ K원까지 갱신하면 되는거였다.
public class 동전1_2293 {
    static int N, K;
    static int[] coins;
    static int[] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        DP = new int[K + 1];
        DP[0] = 1;
        for(int i = 0; i < N; i++) {
            for(int j = coins[i]; j <= K; j++) {
                DP[j] += DP[j - coins[i]];
            }
        }

        System.out.println(DP[K]);
    }
}
