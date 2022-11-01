import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사2_15486 {
    static int N;
    static int[] time;
    static int[] price;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        time = new int[N];
        price = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        DP = new int[N + 1];
        for(int i = 0; i < N; i++) {
            if(i + time[i] <= N) {
                DP[i + time[i]] = Math.max(DP[i + time[i]], DP[i] + price[i]);
            }

            DP[i + 1] = Math.max(DP[i + 1], DP[i]);
        }

        System.out.println(DP[N]);
    }
}
