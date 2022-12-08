import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합분해2225 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] DP = new int[N+1];

        for(int i = 0; i <= N; i++) {
            DP[i] = 1;
        }

        for(int i = 2; i <= K; i++) {
            for(int j = 0; j <= N; j++) {
                for(int k = 0; k <= N; k++) {
                    if(j - k >= 0) DP[j] += DP[j - k] + 1;
                }
            }
        }

        System.out.println(DP[N]);
    }
}
