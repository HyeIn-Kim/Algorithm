import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP로 푸는 방법.
// 수열 숫자 N개 x 최대 K개 삭제했음 으로 계산한다.
public class 가장긴짝수연속한부분수열22857_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int[][] DP = new int[N+1][K+1];
        for(int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            for(int j = 0; j <= K; j++) {
                // 현재 칸이 짝수라면 K가 증가하지 않음. 이전 수열의 값에서 + 1만 해준다.
                if(numbers[i] % 2 == 0) DP[i][j] = DP[i-1][j] + 1;
                // 홀수라면 K가 증가하므로 이전수열x(K-1) 위치에서 값을 그대로 가져온다. 짝수만 세니까 +1은 안해줘도 된다.
                if(j != 0 && numbers[i] % 2 != 0) DP[i][j] = DP[i-1][j-1];
            }
        }

        int answer = 0;
        for(int i = 1; i <= N; i++) {
            answer = Math.max(answer, DP[i][K]);
        }

        System.out.println(answer);
    }
}
