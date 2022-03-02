import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 100까지의 조합은 long 범위도 훌쩍 넘어버린다.
// 파스칼의 삼각형으로 구했음
public class 조합2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BigInteger[][] DP = new BigInteger[N+1][N+1];
        // 초기화
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++) {
                DP[i][j] = new BigInteger("0");
            }
        }
        // 0C0 = 1을 세팅
        DP[0][0] = new BigInteger("1");

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) DP[i][j] = DP[i-1][j];
                // BigInteger 값은 String으로 저장되므로 연산자 대신 .add 함수로 더해줘야 함
                else DP[i][j] = DP[i-1][j-1].add(DP[i-1][j]);
            }
        }

        System.out.println(DP[N][M]);
    }
}
