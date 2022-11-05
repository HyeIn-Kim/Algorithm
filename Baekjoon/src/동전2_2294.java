import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 동전2_2294 {
    static int N, K;
    static HashSet<Integer> set;
    static int[] DP;
    static final int MAX = 12345678;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        set = new HashSet<>();

        // 중복된 동전이 들어올 수 있으므로 set으로 걸러줌
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        // DP[K원] = 동전 개수, 최소값이니까 적당히 큰 값으로 대체함
        DP = new int[K + 1];
        for(int i = 1; i <= K; i++) {
            DP[i] = MAX;
        }

        for(Integer coin : set) {
            for(int i = coin; i <= K; i++) {
                // DP[i] = 현재 동전을 사용하지 않았을 때
                // DP[i - coin] + 1: 현재 동전을 사용할 때
                DP[i] = Math.min(DP[i], DP[i - coin] + 1);
            }
        }

        System.out.println(DP[K] == MAX ? -1 : DP[K]);
    }
}
