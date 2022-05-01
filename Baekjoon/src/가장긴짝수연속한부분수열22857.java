import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 투포인터 버전
// 홀수 개수가 K개인지를 파악하여 L, R를 옮겨주면서 구할 수 있다.
public class 가장긴짝수연속한부분수열22857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int max = numbers[0] % 2 == 0 ? 1 : 0;
        int cnt = numbers[0] % 2 == 0 ? 0 : 1;
        int L = 0;
        int R = 0;
        while(L <= R) {
            if(cnt <= K) {
                R++;
                if(R >= N) break;
                if(numbers[R] % 2 != 0) cnt++;
                max = Math.max(max, R - L + 1 - cnt);
            }
            else {
                if(numbers[L] % 2 != 0) cnt--;
                L++;
            }
        }

        System.out.println(max);
    }
}
