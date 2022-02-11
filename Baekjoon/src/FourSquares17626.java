import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FourSquares17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N+1];
        DP[1] = 1;
        // 처음에는 무조건 루트의 제곱 + (전체 - 루트제곱)으로 구했었는데,
        // 항상 최소값이 나오는 게 아니었다.
        // 따라서 루트제곱부터 1까지 쭉 돌면서 최소값을 찾았음.
        for(int i = 2; i <= N; i++) {
            int sqrt = (int)Math.floor (Math.sqrt(i));
            DP[i] = DP[i - (sqrt * sqrt)] + 1;
            for(int j = sqrt; j >= 1; j--) {
                DP[i] = Math.min(DP[i], DP[i - (j * j)] + 1);
            }
        }

        System.out.println(DP[N]);
    }
}
